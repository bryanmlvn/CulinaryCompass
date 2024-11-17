package com.example.culinarycompass.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class IngredientsItem{

	@SerializedName("image")
	private String image;

	@SerializedName("localizedName")
	private String localizedName;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("amount")
	private Object amount;

	@SerializedName("unit")
	private String unit;

	@SerializedName("nutrients")
	private List<NutrientsItem> nutrients;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setLocalizedName(String localizedName){
		this.localizedName = localizedName;
	}

	public String getLocalizedName(){
		return localizedName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

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

	public void setNutrients(List<NutrientsItem> nutrients){
		this.nutrients = nutrients;
	}

	public List<NutrientsItem> getNutrients(){
		return nutrients;
	}
}