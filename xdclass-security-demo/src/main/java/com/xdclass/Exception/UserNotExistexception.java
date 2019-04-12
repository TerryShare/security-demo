package com.xdclass.Exception;

public class UserNotExistexception extends RuntimeException{
	
	private static final long serialVersionUID= -6112790192479692859l;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserNotExistexception(String id) {
		
		super("user not exist");
		this.id=id;
	}

}
