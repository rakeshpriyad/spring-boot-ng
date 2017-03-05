package com.test.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Shipping implements Serializable {

	public Shipping() {
	}

	@Id
	@Column(name = "shippingId")
	private Integer shippingId;

	@Column(name = "userId")
	private String userId;

	@Column(name = "mobileNo")
	private String mobileNo;

	@Column(name = "state")
	private String state;

	@Column(name = "address1")
	private String address1;

	@Column(name = "postalCode")
	private String postalCode;

	@Column(name = "shippingName")
	private String shippingName;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "address2")
	private String address2;

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public Integer getShippingId() {
		return this.shippingId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public String getState() {
		return this.state;
	}

	public String getAddress1() {
		return this.address1;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public String getShippingName() {
		return this.shippingName;
	}

	public String getCountry() {
		return this.country;
	}

	public String getCity() {
		return this.city;
	}

	public String getAddress2() {
		return this.address2;
	}

}
