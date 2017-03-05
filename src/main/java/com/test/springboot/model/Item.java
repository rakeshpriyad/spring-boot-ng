package com.test.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Item implements Serializable {

	public Item() {
	}

	@Id
	@Column(name = "itemId")
	private Long itemId;

	@Column(name = "description")
	private String description;

	@Column(name = "itemName")
	private String itemName;

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return this.description;
	}

	public String getItemName() {
		return this.itemName;
	}

}
