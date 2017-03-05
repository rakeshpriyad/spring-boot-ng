package com.test.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Company implements Serializable {

	public Company() {
	}

	@Id
	@Column(name = "companyId")
	private Long companyId;

	@Column(name = "description")
	private String description;

	@Column(name = "companyName")
	private String companyName;

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return this.description;
	}

	public String getCompanyName() {
		return this.companyName;
	}

}
