package com.bluebird.dto;

public class TraderBranchDetailsDTO {

	private String branchName;
	private int operationRadius;
	private String telephone1;
	private String telephone2;
	private String telephone3;
	private String mobile;
	private boolean active;
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getOperationRadius() {
		return operationRadius;
	}
	public void setOperationRadius(int operationRadius) {
		this.operationRadius = operationRadius;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
