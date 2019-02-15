package com.xupt.exceptions;

public class UserNotExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4385292017525404033L;
	
	private String id;
	
	public UserNotExistException(String id) {
		super("user not exist");
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
