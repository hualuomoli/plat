package com.github.hualuomoli.shiro.exception;

/**
 * there is the login user
 * @author liubaoquan
 *
 */
public class NoLoginUserException extends RuntimeException {

	private static final long serialVersionUID = 1934097509861812066L;

	public NoLoginUserException() {
		super();
	}

	public NoLoginUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoLoginUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoLoginUserException(String message) {
		super(message);
	}

	public NoLoginUserException(Throwable cause) {
		super(cause);
	}

}
