package com.github.hualuomoli.shiro.exception;

/**
 * login user is invalidate
 * such as the password con't match
 * @author liubaoquan
 *
 */
public class InvalidateLoginUserException extends RuntimeException {

	private static final long serialVersionUID = -7322171326150299942L;

	public InvalidateLoginUserException() {
		super();
	}

	public InvalidateLoginUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidateLoginUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidateLoginUserException(String message) {
		super(message);
	}

	public InvalidateLoginUserException(Throwable cause) {
		super(cause);
	}

}
