package com.bluebird.dto;

import java.util.Date;

public class RegisterDTO {

	private String email;

	private int userType;
	
	private String name;
	
	private String directorName;
	
	private String companyRegisterNumber;
	
	private String companyVatNumber;
	
	private String websiteUrl;
	
	private String contactPerson;
	
	private String telephone1;
	
	private String telephone2;
	
	private String telephone3;
	
	private String mobile;
	
	private String fbUrl;
	
	private String twitterUrl;
	
	private Date createdAt;
	
	private Date modifiedAt;
	
	
	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getCompanyRegisterNumber() {
		return companyRegisterNumber;
	}

	public void setCompanyRegisterNumber(String companyRegisterNumber) {
		this.companyRegisterNumber = companyRegisterNumber;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getTelephone3() {
		return telephone3;
	}

	public void setTelephone3(String telephone3) {
		this.telephone3 = telephone3;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFbUrl() {
		return fbUrl;
	}

	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
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

	public String getCompanyVatNumber() {
		return companyVatNumber;
	}

	public void setCompanyVatNumber(String companyVatNumber) {
		this.companyVatNumber = companyVatNumber;
	}
	
	
}
