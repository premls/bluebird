package com.bluebird.dto;

import java.util.Date;

public class RegisterDTO {

	private String email;

	private int userType;

	private String title;
	
	private String lastName;
	
	private String password;
	
	private String firstName;
	
	private String mobile;
	
	private Date createdAt;
	
	private Date modifiedAt;
	
	private String expertise;
	
	private boolean status;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	@Override
	public String toString() {
		StringBuffer registerValues = new StringBuffer();
		registerValues.append("email=").append(email).append(";").
		append("userType=").append(userType).append(";").
		append("title=").append(title).append(";").
		append("lastName=").append(lastName).append(";").
		append("firstName=").append(firstName).append(";").
		append("mobile=").append(mobile);
		return registerValues.toString();
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
