package com.example.culinarycompass.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Nutrition{

	@SerializedName("caloricBreakdown")
	private CaloricBreakdown caloricBreakdown;

	@SerializedName("weightPerServing")
	private WeightPerServing weightPerServing;

	@SerializedName("ingredients")
	private List<IngredientsItem> ingredients;

	@SerializedName("flavonoids")
	private List<FlavonoidsItem> flavonoids;

	@SerializedName("properties")
	private List<PropertiesItem> properties;

	@SerializedName("nutrients")
	private List<NutrientsItem> nutrients;

	public void setCaloricBreakdown(CaloricBreakdown caloricBreakdown){
		this.caloricBreakdown = caloricBreakdown;
	}

	public CaloricBreakdown getCaloricBreakdown(){
		return caloricBreakdown;
	}

	public void setWeightPerServing(WeightPerServing weightPerServing){
		this.weightPerServing = weightPerServing;
	}

	public WeightPerServing getWeightPerServing(){
		return weightPerServing;
	}

	public void setIngredients(List<IngredientsItem> ingredients){
		this.ingredients = ingredients;
	}

	public List<IngredientsItem> getIngredients(){
		return ingredients;
	}

	public void setFlavonoids(List<FlavonoidsItem> flavonoids){
		this.flavonoids = flavonoids;
	}

	public List<FlavonoidsItem> getFlavonoids(){
		return flavonoids;
	}

	public void setProperties(List<PropertiesItem> properties){
		this.properties = properties;
	}

	public List<PropertiesItem> getProperties(){
		return properties;
	}

	public void setNutrients(List<NutrientsItem> nutrients){
		this.nutrients = nutrients;
	}

	public List<NutrientsItem> getNutrients(){
		return nutrients;
	}
}