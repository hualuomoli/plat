package com.github.hualuomoli.shiro.service.impl;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.hualuomoli.shiro.exception.InvalidateLoginUserException;
import com.github.hualuomoli.shiro.exception.NoLoginUserException;
import com.github.hualuomoli.shiro.service.IShiroUserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * implements demo
 * @author liubaoquan
 *
 */
@Service
public class DefaultShiroUserService implements IShiroUserService {

	@Override
	public Set<String> getRoles(String userName) {
		return Sets.newHashSet("admin");
	}

	@Override
	public Collection<String> getPermissions(String userName) {
		return Lists.newArrayList("index");
	}

	@Override
	public void hasUser(String userName) throws NoLoginUserException {
		// user is system
		if (!StringUtils.equals(userName, "system")) {
			throw new NoLoginUserException("there is not user " + userName);
		}
	}

	@Override
	public void extend(SimpleAuthorizationInfo info, String userName) {
		// add demo permission
		info.addStringPermission("demo");
	}

	@Override
	public void checkUser(String userName, String password) throws InvalidateLoginUserException {
		// user is system
		if (!StringUtils.equals(userName, "system") || !StringUtils.equals(password, "123456")) {
			throw new InvalidateLoginUserException("userName or password is invalidate");
		}
	}

}
