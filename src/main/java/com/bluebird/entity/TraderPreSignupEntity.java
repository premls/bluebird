package com.bluebird.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "trader_pre_singup")
public class TraderPreSignupEntity {

	@Id
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "director_name")
	private String directorName;
	
	@Column(name = "company_register_number")
	private String companyRegisterNumber;
	
	@Column(name = "company_vat_number")
	private String companyVatNumber;
	
	@Column(name = "website_url")
	private String websiteUrl;
	
	@Column(name = "contact_person")
	private String contactPerson;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone_1")
	private String telephone1;
	
	@Column(name = "telephone_2")
	private String telephone2;
	
	@Column(name = "telephone_3")
	private String telephone3;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "fb_url")
	private String fbUrl;
	
	@Column(name = "twitter_url")
	private String twitterUrl;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "modified_at")
	private Date modifiedAt;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
