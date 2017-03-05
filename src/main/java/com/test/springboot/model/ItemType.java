package com.test.springboot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class ItemType implements Serializable {

	public ItemType() {
	}

	@Id
	@Column(name = "itemTypeId")
	private Long itemTypeId;

	@Column(name = "support")
	private String support;

	@Column(name = "description")
	private String description;

	@Column(name = "offers")
	private String offers;

	@Column(name = "itemTypeName")
	private String itemTypeName;

	@Column(name = "screenSize")
	private String screenSize;

	@Column(name = "facility")
	private String facility;

	public void setItemTypeId(Long itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public Long getItemTypeId() {
		return this.itemTypeId;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getSupport() {
		return this.support;
	}

	public String getDescription() {
		return this.description;
	}

	public String getOffers() {
		return this.offers;
	}

	public String getItemTypeName() {
		return this.itemTypeName;
	}

	public String getScreenSize() {
		return this.screenSize;
	}

	public String getFacility() {
		return this.facility;
	}

}
