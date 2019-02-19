package com.xupt.security.core.validate.core;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2492896377931993246L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
