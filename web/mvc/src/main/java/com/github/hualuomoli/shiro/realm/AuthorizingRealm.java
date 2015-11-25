package com.github.hualuomoli.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hualuomoli.shiro.exception.InvalidateLoginUserException;
import com.github.hualuomoli.shiro.exception.NoLoginUserException;
import com.github.hualuomoli.shiro.service.IShiroUserService;
import com.github.hualuomoli.shiro.util.ShiroUtils;

/**
 * auto write
 * @author liubaoquan
 *
 */
@Service(value = "authorizingRealm")
public class AuthorizingRealm extends org.apache.shiro.realm.AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizingRealm.class);

	@Autowired
	private IShiroUserService shiroUserService;

	// get user authorization
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo info = null;
		String userName = null;

		try {
			// login userName
			userName = (String) principalCollection.fromRealm(getName()).iterator().next();
			info = new SimpleAuthorizationInfo();
			// there has the login user
			// shiroUserService.hasUser(userName);
			// roles
			info.setRoles(shiroUserService.getRoles(userName));
			// permissions
			info.addStringPermissions(shiroUserService.getPermissions(userName));
			// extend Authorization info such as add test role permission
			shiroUserService.extend(info, userName);
			// return user info
			return info;
		} catch (NoLoginUserException noLoginUserException) {
			logger.warn("there is no login user which userName is {}.\n\t{}", userName, noLoginUserException);
		} catch (Exception e) {
			logger.error("get authorization error.", e);
		}
		return null;
	}

	// set login userName and password
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		try {
			// UsernamePasswordToken对象用来存放提交的登录信息
			UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
			shiroUserService.hasUser(token.getUsername());
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName()); // create authentication info
			ShiroUtils.storeLoginUser(token.getUsername()); // store login user
			return authcInfo;
		} catch (NoLoginUserException e) {
			throw new AuthenticationException(e);
		}
	}

	// check login user
	@Override
	protected void assertCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		try {
			shiroUserService.checkUser(token.getUsername(), new String(token.getPassword()));
		} catch (InvalidateLoginUserException e) {
			throw new AuthenticationException(e);
		}
	}

}
