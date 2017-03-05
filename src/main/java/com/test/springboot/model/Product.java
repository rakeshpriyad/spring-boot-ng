package com.test.springboot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Product implements Serializable {

	public Product() {
	}

	@Id
	@Column(name = "productId")
	private Integer productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "description")
	private String description;

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return this.productName;
	}

	public String getDescription() {
		return this.description;
	}
}
