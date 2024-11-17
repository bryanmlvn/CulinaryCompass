package com.example.culinarycompass.model;

import com.google.gson.annotations.SerializedName;

public class NutrientsItem{

	@SerializedName("amount")
	private Object amount;

	@SerializedName("unit")
	private String unit;

	@SerializedName("percentOfDailyNeeds")
	private int percentOfDailyNeeds;

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

	public void setPercentOfDailyNeeds(int percentOfDailyNeeds){
		this.percentOfDailyNeeds = percentOfDailyNeeds;
	}

	public int getPercentOfDailyNeeds(){
		return percentOfDailyNeeds;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}