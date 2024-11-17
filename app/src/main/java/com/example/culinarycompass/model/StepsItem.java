package com.example.culinarycompass.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class StepsItem{

	@SerializedName("number")
	private int number;

	@SerializedName("length")
	private Length length;

	@SerializedName("ingredients")
	private List<IngredientsItem> ingredients;

	@SerializedName("equipment")
	private List<EquipmentItem> equipment;

	@SerializedName("step")
	private String step;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setLength(Length length){
		this.length = length;
	}

	public Length getLength(){
		return length;
	}

	public void setIngredients(List<IngredientsItem> ingredients){
		this.ingredients = ingredients;
	}

	public List<IngredientsItem> getIngredients(){
		return ingredients;
	}

	public void setEquipment(List<EquipmentItem> equipment){
		this.equipment = equipment;
	}

	public List<EquipmentItem> getEquipment(){
		return equipment;
	}

	public void setStep(String step){
		this.step = step;
	}

	public String getStep(){
		return step;
	}
}