package com.example.culinarycompass.model;

import com.google.gson.annotations.SerializedName;

public class WeightPerServing{

	@SerializedName("amount")
	private int amount;

	@SerializedName("unit")
	private String unit;

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
}