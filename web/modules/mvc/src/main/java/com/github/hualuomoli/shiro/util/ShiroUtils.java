package com.github.hualuomoli.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.hualuomoli.shiro.exception.InvalidateLoginUserException;

/**
 * shiro tool
 * @author liubaoquan
 *
 */
public class ShiroUtils {

	private static final Logger logger = LoggerFactory.getLogger(ShiroUtils.class);

	private static final String USER_NAME = "userName"; // 用户名的key

	private ShiroUtils() {
	}

	/**
	 * login
	 * @param userName login userName
	 * @param password login password
	 * @throws InvalidateLoginUserException userName or password invalidate
	 */
	public static void login(String userName, String password) throws InvalidateLoginUserException {
		try {
			Subject subject = getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken();
			token.setUsername(userName);
			token.setPassword(password.toCharArray());
			subject.login(token);
		} catch (Exception e) {
			throw new InvalidateLoginUserException("userName or password error.", e);
		}
	}

	// get subject
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	// get principal
	public static Object getPrincipal() {
		Subject subject = getSubject();
		return subject.getPrincipal();
	}

	// get session
	public static Session getSession() {
		Subject subject = getSubject();
		return subject.getSession();
	}

	/**
	 * store login user to shiro session
	 * @param userName login userName
	 */
	public static void storeLoginUser(String userName) {
		store(USER_NAME, userName);
	}

	/**
	 * store data to shiro session
	 * @param key data's key
	 * @param value data's value
	 */
	public static void store(Object key, Object value) {
		Session session = getSession();
		session.setAttribute(key, value);
		if (logger.isDebugEnabled()) {
			logger.debug("session timeout default {} s", session.getTimeout() / 1000);
		}
	}

	/**
	 * get login user from shiro session
	 * @return login userName
	 */
	public static String getLoginUser() {
		return (String) get(USER_NAME);
	}

	/**
	 * get data from shiro session
	 * @param key data's key
	 * @return data's value
	 */
	public static Object get(Object key) {
		Session session = getSession();
		return session.getAttribute(key);
	}

}
