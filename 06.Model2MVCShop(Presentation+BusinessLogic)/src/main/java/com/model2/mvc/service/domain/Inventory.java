package com.model2.mvc.service.domain;

import java.util.Date;

public class Inventory {
	
	private int inventoryNo;
	private Product product;
	private Warehouse wareHouse;
	private int inQuanity;
	private Date inDate;
	private int outQuanity=0;
	private String outDate;
	private int inventoryQuanity;

	public Inventory(){
	}
	
	public Warehouse getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(Warehouse wareHouse) {
		this.wareHouse = wareHouse;
	}
	
	public int getInventoryNo() {
		return inventoryNo;
	}


	public void setInventoryNo(int inventoryNo) {
		this.inventoryNo = inventoryNo;
	}



	public int getInQuanity() {
		return inQuanity;
	}


	public void setInQuanity(int inQuanity) {
		this.inQuanity = inQuanity;
	}


	public Date getInDate() {
		return inDate;
	}


	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}


	public int getOutQuanity() {
		return outQuanity;
	}


	public void setOutQuanity(int outQuanity) {
		this.outQuanity = outQuanity;
	}


	public String getOutDate() {
		return outDate;
	}


	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}


	public int getInventoryQuanity() {
		return inventoryQuanity;
	}


	public void setInventoryQuanity(int inventoryQuanity) {
		this.inventoryQuanity = inventoryQuanity;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryNo=" + inventoryNo + ", product=" + product + ", wareHouse=" + wareHouse
				+ ", inQuanity=" + inQuanity + ", inDate=" + inDate + ", outQuanity=" + outQuanity + ", outDate="
				+ outDate + ", inventoryQuanity=" + inventoryQuanity + "]";
	}
	
}