package com.example.culinarycompass.model;

import com.google.gson.annotations.SerializedName;

public class Metric{

	@SerializedName("amount")
	private int amount;

	@SerializedName("unitShort")
	private String unitShort;

	@SerializedName("unitLong")
	private String unitLong;

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void setUnitShort(String unitShort){
		this.unitShort = unitShort;
	}

	public String getUnitShort(){
		return unitShort;
	}

	public void setUnitLong(String unitLong){
		this.unitLong = unitLong;
	}

	public String getUnitLong(){
		return unitLong;
	}
}