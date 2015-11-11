package com.bluebird.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "trader_branch")
public class TraderBranchEntity {

	@Id
	private int id;
	
	@Column(name="branch_name")
	private String branchName;

	@Column(name="operation_radius")
	private int operationRadius;
	
	@Column(name="telephone_1")
	private String telephone1;
	
	@Column(name="telephone_2")
	private String telephone2;
	
	@Column(name="telephone_3")
	private String telephone3;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="is_active")
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
