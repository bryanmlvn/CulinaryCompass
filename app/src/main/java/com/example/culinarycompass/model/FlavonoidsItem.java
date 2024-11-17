package com.example.culinarycompass.model;

import com.google.gson.annotations.SerializedName;

public class FlavonoidsItem{

	@SerializedName("amount")
	private int amount;

	@SerializedName("unit")
	private String unit;

	@SerializedName("name")
	private String name;

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
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