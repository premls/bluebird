package com.bluebird.util;

public enum UserType {

	CUSTOMER(1),TRADER(2);
	
	private int id;
	
	private UserType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}
