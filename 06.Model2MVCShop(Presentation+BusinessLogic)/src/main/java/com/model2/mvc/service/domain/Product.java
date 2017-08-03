package com.model2.mvc.service.domain;

import java.sql.Date;


public class Product {

	private String fileName;
	private String manuDate;
	private int price;
	private String prodDetail;
	private String prodName;
	private int prodNo;
	private Date regDate;
	private String proTranCode;
	private int quanity;
	private String wareHouseCode;

	
	public Product(){
	}

	
	public Product(String fileName, String manuDate, int price, String prodDetail, String prodName, int prodNo,
			Date regDate, String proTranCode, int quanity, String wareHouseCode) {
		this.fileName = fileName;
		this.manuDate = manuDate;
		this.price = price;
		this.prodDetail = prodDetail;
		this.prodName = prodName;
		this.prodNo = prodNo;
		this.regDate = regDate;
		this.proTranCode = proTranCode;
		this.quanity = quanity;
		this.wareHouseCode = wareHouseCode;
	}

	
	public String getProTranCode() {
		return proTranCode;
	}
	public void setProTranCode(String proTranCode) {
		this.proTranCode = proTranCode;
	}
	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public String getWareHouseCode() {
		return wareHouseCode;
	}

	public void setWareHouseCode(String wareHouseCode) {
		this.wareHouseCode = wareHouseCode;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getManuDate() {
		return manuDate;
	}
	public void setManuDate(String manuDate) {
		this.manuDate = manuDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	// Override
	public String toString() {
		return "ProductVO : [fileName]" + fileName + "[proTranCode]" + proTranCode 
				+ "[manuDate]" + manuDate+ "[price]" + price + "[prodDetail]" + prodDetail
				+ "[prodName]" + prodName + "[prodNo]" + prodNo
				+ "[quanity]" + quanity + "[warehouse_code]" + wareHouseCode
				+ "[quanity]" + quanity;
	}	
}