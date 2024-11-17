package com.example.culinarycompass.model;

import com.google.gson.annotations.SerializedName;

public class CaloricBreakdown{

	@SerializedName("percentCarbs")
	private Object percentCarbs;

	@SerializedName("percentProtein")
	private Object percentProtein;

	@SerializedName("percentFat")
	private Object percentFat;

	public void setPercentCarbs(Object percentCarbs){
		this.percentCarbs = percentCarbs;
	}

	public Object getPercentCarbs(){
		return percentCarbs;
	}

	public void setPercentProtein(Object percentProtein){
		this.percentProtein = percentProtein;
	}

	public Object getPercentProtein(){
		return percentProtein;
	}

	public void setPercentFat(Object percentFat){
		this.percentFat = percentFat;
	}

	public Object getPercentFat(){
		return percentFat;
	}
}