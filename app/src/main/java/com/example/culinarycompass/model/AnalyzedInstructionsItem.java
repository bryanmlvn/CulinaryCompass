package com.example.culinarycompass.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AnalyzedInstructionsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("steps")
	private List<StepsItem> steps;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSteps(List<StepsItem> steps){
		this.steps = steps;
	}

	public List<StepsItem> getSteps(){
		return steps;
	}
}