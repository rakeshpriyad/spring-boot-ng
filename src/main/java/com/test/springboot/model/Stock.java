package com.test.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Stock implements Serializable {

	public Stock() {
	}

	@Id
	@Column(name = "stockId")
	private Long stockId;

	@Column(name = "qtyUnit")
	private String qtyUnit;

	@Column(name = "price")
	private String price;

	@Column(name = "stockName")
	private String stockName;

	@Column(name = "item_id")
	private String item_id;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "imageName")
	private String imageName;

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getStockId() {
		return this.stockId;
	}

	public void setQtyUnit(String qtyUnit) {
		this.qtyUnit = qtyUnit;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getQtyUnit() {
		return this.qtyUnit;
	}

	public String getPrice() {
		return this.price;
	}

	public String getStockName() {
		return this.stockName;
	}

	public String getItem_id() {
		return this.item_id;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public String getImageName() {
		return this.imageName;
	}

}
