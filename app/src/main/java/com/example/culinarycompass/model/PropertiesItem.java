package com.example.culinarycompass.model;

import com.google.gson.annotations.SerializedName;

public class PropertiesItem{

	@SerializedName("amount")
	private Object amount;

	@SerializedName("unit")
	private String unit;

	@SerializedName("name")
	private String name;

	public void setAmount(Object amount){
		this.amount = amount;
	}

	public Object getAmount(){
		return amount;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}