package com.example.culinarycompass.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MissedIngredientsItem{

	@SerializedName("originalName")
	private String originalName;

	@SerializedName("image")
	private String image;

	@SerializedName("amount")
	private int amount;

	@SerializedName("unit")
	private String unit;

	@SerializedName("unitShort")
	private String unitShort;

	@SerializedName("original")
	private String original;

	@SerializedName("meta")
	private List<String> meta;

	@SerializedName("name")
	private String name;

	@SerializedName("unitLong")
	private String unitLong;

	@SerializedName("id")
	private int id;

	@SerializedName("aisle")
	private String aisle;

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

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

	public void setUnitShort(String unitShort){
		this.unitShort = unitShort;
	}

	public String getUnitShort(){
		return unitShort;
	}

	public void setOriginal(String original){
		this.original = original;
	}

	public String getOriginal(){
		return original;
	}

	public void setMeta(List<String> meta){
		this.meta = meta;
	}

	public List<String> getMeta(){
		return meta;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUnitLong(String unitLong){
		this.unitLong = unitLong;
	}

	public String getUnitLong(){
		return unitLong;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAisle(String aisle){
		this.aisle = aisle;
	}

	public String getAisle(){
		return aisle;
	}
}