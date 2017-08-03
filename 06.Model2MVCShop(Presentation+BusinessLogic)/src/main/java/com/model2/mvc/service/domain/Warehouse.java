package com.model2.mvc.service.domain;

public class Warehouse {
	
	private String warehouse_code ;
	private String warehouse_location;
	private String warehouse_usage;
	private String warehouse_telno;
	private int    warehouse_occupation_rate;
	
	
	
	public Warehouse() {
	}



	public String getWarehouse_code() {
		return warehouse_code;
	}



	public void setWarehouse_code(String warehouse_code) {
		this.warehouse_code = warehouse_code;
	}



	public String getWarehouse_location() {
		return warehouse_location;
	}



	public void setWarehouse_location(String warehouse_location) {
		this.warehouse_location = warehouse_location;
	}



	public String getWarehouse_usage() {
		return warehouse_usage;
	}



	public void setWarehouse_usage(String warehouse_usage) {
		this.warehouse_usage = warehouse_usage;
	}



	public String getWarehouse_telno() {
		return warehouse_telno;
	}



	public void setWarehouse_telno(String warehouse_telno) {
		this.warehouse_telno = warehouse_telno;
	}



	public int getWarehouse_occupation_rate() {
		return warehouse_occupation_rate;
	}



	public void setWarehouse_occupation_rate(int warehouse_occupation_rate) {
		this.warehouse_occupation_rate = warehouse_occupation_rate;
	}



	@Override
	public String toString() {
		return "Warehouse [warehouse_code=" + warehouse_code + ", warehouse_location=" + warehouse_location
				+ ", warehouse_usage=" + warehouse_usage + ", warehouse_telno=" + warehouse_telno
				+ ", warehouse_occupation_rate=" + warehouse_occupation_rate + ", getWarehouse_code()="
				+ getWarehouse_code() + ", getWarehouse_location()=" + getWarehouse_location()
				+ ", getWarehouse_usage()=" + getWarehouse_usage() + ", getWarehouse_telno()=" + getWarehouse_telno()
				+ ", getWarehouse_occupation_rate()=" + getWarehouse_occupation_rate() + "]";
	}


}