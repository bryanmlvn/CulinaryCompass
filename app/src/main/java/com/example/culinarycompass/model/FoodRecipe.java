package com.example.culinarycompass.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FoodRecipe{

	@SerializedName("number")
	private int number;

	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("offset")
	private int offset;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}
}