package com.github.hualuomoli.shiro.service;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

import com.github.hualuomoli.shiro.exception.InvalidateLoginUserException;
import com.github.hualuomoli.shiro.exception.NoLoginUserException;

public interface IShiroUserService {

	/**
	 * get roles by login userName
	 * @param userName login userName
	 * @return all role that the query login has
	 */
	Set<String> getRoles(String userName);

	/**
	 * get permission by login userName
	 * @param userName login userName
	 * @return all permission that the query login has
	 */
	Collection<String> getPermissions(String userName);

	/**
	 * login user exist or not
	 * @param userName login userName
	 */
	void hasUser(String userName) throws NoLoginUserException;

	/**
	 * extend Authorization info such as add test role permission
	 * @param info Authorization Info
	 * @param userName login userName
	 */
	void extend(SimpleAuthorizationInfo info, String userName);

	/**
	 * check login user
	 * @param userName login userName
	 * @param password password
	 * @throws InvalidateLoginUserException
	 */
	void checkUser(String userName, String password) throws InvalidateLoginUserException;

}
