package com.nagarro.constants;

public enum UserType {
	Admin("Admin"),Employee("Employee");
	private String userType;
	private UserType(String userType) {
		this.userType=userType;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
