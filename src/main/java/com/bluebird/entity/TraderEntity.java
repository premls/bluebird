package com.bluebird.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "trader")
public class TraderEntity {

	private Id id;
	
	private String name;

	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_at")
	private Date createdAt;

	 
	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
