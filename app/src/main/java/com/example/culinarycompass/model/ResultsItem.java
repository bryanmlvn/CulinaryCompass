package com.example.culinarycompass.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("usedIngredients")
	private List<Object> usedIngredients;

	@SerializedName("sustainable")
	private boolean sustainable;

	@SerializedName("analyzedInstructions")
	private List<AnalyzedInstructionsItem> analyzedInstructions;

	@SerializedName("glutenFree")
	private boolean glutenFree;

	@SerializedName("veryPopular")
	private boolean veryPopular;

	@SerializedName("healthScore")
	private int healthScore;

	@SerializedName("title")
	private String title;

	@SerializedName("diets")
	private List<String> diets;

	@SerializedName("aggregateLikes")
	private int aggregateLikes;

	@SerializedName("creditsText")
	private String creditsText;

	@SerializedName("readyInMinutes")
	private int readyInMinutes;

	@SerializedName("sourceUrl")
	private String sourceUrl;

	@SerializedName("dairyFree")
	private boolean dairyFree;

	@SerializedName("servings")
	private int servings;

	@SerializedName("missedIngredients")
	private List<MissedIngredientsItem> missedIngredients;

	@SerializedName("vegetarian")
	private boolean vegetarian;

	@SerializedName("unusedIngredients")
	private List<Object> unusedIngredients;

	@SerializedName("id")
	private int id;

	@SerializedName("preparationMinutes")
	private Object preparationMinutes;

	@SerializedName("imageType")
	private String imageType;

	@SerializedName("likes")
	private int likes;

	@SerializedName("summary")
	private String summary;

	@SerializedName("cookingMinutes")
	private Object cookingMinutes;

	@SerializedName("image")
	private String image;

	@SerializedName("veryHealthy")
	private boolean veryHealthy;

	@SerializedName("vegan")
	private boolean vegan;

	@SerializedName("cheap")
	private boolean cheap;

	@SerializedName("extendedIngredients")
	private List<ExtendedIngredientsItem> extendedIngredients;

	@SerializedName("dishTypes")
	private List<String> dishTypes;

	@SerializedName("gaps")
	private String gaps;

	@SerializedName("cuisines")
	private List<Object> cuisines;

	@SerializedName("usedIngredientCount")
	private int usedIngredientCount;

	@SerializedName("lowFodmap")
	private boolean lowFodmap;

	@SerializedName("license")
	private String license;

	@SerializedName("nutrition")
	private Nutrition nutrition;

	@SerializedName("weightWatcherSmartPoints")
	private int weightWatcherSmartPoints;

	@SerializedName("missedIngredientCount")
	private int missedIngredientCount;

	@SerializedName("occasions")
	private List<Object> occasions;

	@SerializedName("pricePerServing")
	private Object pricePerServing;

	@SerializedName("spoonacularScore")
	private Object spoonacularScore;

	@SerializedName("sourceName")
	private String sourceName;

	@SerializedName("spoonacularSourceUrl")
	private String spoonacularSourceUrl;

	public void setUsedIngredients(List<Object> usedIngredients){
		this.usedIngredients = usedIngredients;
	}

	public List<Object> getUsedIngredients(){
		return usedIngredients;
	}

	public void setSustainable(boolean sustainable){
		this.sustainable = sustainable;
	}

	public boolean isSustainable(){
		return sustainable;
	}

	public void setAnalyzedInstructions(List<AnalyzedInstructionsItem> analyzedInstructions){
		this.analyzedInstructions = analyzedInstructions;
	}

	public List<AnalyzedInstructionsItem> getAnalyzedInstructions(){
		return analyzedInstructions;
	}

	public void setGlutenFree(boolean glutenFree){
		this.glutenFree = glutenFree;
	}

	public boolean isGlutenFree(){
		return glutenFree;
	}

	public void setVeryPopular(boolean veryPopular){
		this.veryPopular = veryPopular;
	}

	public boolean isVeryPopular(){
		return veryPopular;
	}

	public void setHealthScore(int healthScore){
		this.healthScore = healthScore;
	}

	public int getHealthScore(){
		return healthScore;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDiets(List<String> diets){
		this.diets = diets;
	}

	public List<String> getDiets(){
		return diets;
	}

	public void setAggregateLikes(int aggregateLikes){
		this.aggregateLikes = aggregateLikes;
	}

	public int getAggregateLikes(){
		return aggregateLikes;
	}

	public void setCreditsText(String creditsText){
		this.creditsText = creditsText;
	}

	public String getCreditsText(){
		return creditsText;
	}

	public void setReadyInMinutes(int readyInMinutes){
		this.readyInMinutes = readyInMinutes;
	}

	public int getReadyInMinutes(){
		return readyInMinutes;
	}

	public void setSourceUrl(String sourceUrl){
		this.sourceUrl = sourceUrl;
	}

	public String getSourceUrl(){
		return sourceUrl;
	}

	public void setDairyFree(boolean dairyFree){
		this.dairyFree = dairyFree;
	}

	public boolean isDairyFree(){
		return dairyFree;
	}

	public void setServings(int servings){
		this.servings = servings;
	}

	public int getServings(){
		return servings;
	}

	public void setMissedIngredients(List<MissedIngredientsItem> missedIngredients){
		this.missedIngredients = missedIngredients;
	}

	public List<MissedIngredientsItem> getMissedIngredients(){
		return missedIngredients;
	}

	public void setVegetarian(boolean vegetarian){
		this.vegetarian = vegetarian;
	}

	public boolean isVegetarian(){
		return vegetarian;
	}

	public void setUnusedIngredients(List<Object> unusedIngredients){
		this.unusedIngredients = unusedIngredients;
	}

	public List<Object> getUnusedIngredients(){
		return unusedIngredients;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPreparationMinutes(Object preparationMinutes){
		this.preparationMinutes = preparationMinutes;
	}

	public Object getPreparationMinutes(){
		return preparationMinutes;
	}

	public void setImageType(String imageType){
		this.imageType = imageType;
	}

	public String getImageType(){
		return imageType;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public int getLikes(){
		return likes;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setCookingMinutes(Object cookingMinutes){
		this.cookingMinutes = cookingMinutes;
	}

	public Object getCookingMinutes(){
		return cookingMinutes;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setVeryHealthy(boolean veryHealthy){
		this.veryHealthy = veryHealthy;
	}

	public boolean isVeryHealthy(){
		return veryHealthy;
	}

	public void setVegan(boolean vegan){
		this.vegan = vegan;
	}

	public boolean isVegan(){
		return vegan;
	}

	public void setCheap(boolean cheap){
		this.cheap = cheap;
	}

	public boolean isCheap(){
		return cheap;
	}

	public void setExtendedIngredients(List<ExtendedIngredientsItem> extendedIngredients){
		this.extendedIngredients = extendedIngredients;
	}

	public List<ExtendedIngredientsItem> getExtendedIngredients(){
		return extendedIngredients;
	}

	public void setDishTypes(List<String> dishTypes){
		this.dishTypes = dishTypes;
	}

	public List<String> getDishTypes(){
		return dishTypes;
	}

	public void setGaps(String gaps){
		this.gaps = gaps;
	}

	public String getGaps(){
		return gaps;
	}

	public void setCuisines(List<Object> cuisines){
		this.cuisines = cuisines;
	}

	public List<Object> getCuisines(){
		return cuisines;
	}

	public void setUsedIngredientCount(int usedIngredientCount){
		this.usedIngredientCount = usedIngredientCount;
	}

	public int getUsedIngredientCount(){
		return usedIngredientCount;
	}

	public void setLowFodmap(boolean lowFodmap){
		this.lowFodmap = lowFodmap;
	}

	public boolean isLowFodmap(){
		return lowFodmap;
	}

	public void setLicense(String license){
		this.license = license;
	}

	public String getLicense(){
		return license;
	}

	public void setNutrition(Nutrition nutrition){
		this.nutrition = nutrition;
	}

	public Nutrition getNutrition(){
		return nutrition;
	}

	public void setWeightWatcherSmartPoints(int weightWatcherSmartPoints){
		this.weightWatcherSmartPoints = weightWatcherSmartPoints;
	}

	public int getWeightWatcherSmartPoints(){
		return weightWatcherSmartPoints;
	}

	public void setMissedIngredientCount(int missedIngredientCount){
		this.missedIngredientCount = missedIngredientCount;
	}

	public int getMissedIngredientCount(){
		return missedIngredientCount;
	}

	public void setOccasions(List<Object> occasions){
		this.occasions = occasions;
	}

	public List<Object> getOccasions(){
		return occasions;
	}

	public void setPricePerServing(Object pricePerServing){
		this.pricePerServing = pricePerServing;
	}

	public Object getPricePerServing(){
		return pricePerServing;
	}

	public void setSpoonacularScore(Object spoonacularScore){
		this.spoonacularScore = spoonacularScore;
	}

	public Object getSpoonacularScore(){
		return spoonacularScore;
	}

	public void setSourceName(String sourceName){
		this.sourceName = sourceName;
	}

	public String getSourceName(){
		return sourceName;
	}

	public void setSpoonacularSourceUrl(String spoonacularSourceUrl){
		this.spoonacularSourceUrl = spoonacularSourceUrl;
	}

	public String getSpoonacularSourceUrl(){
		return spoonacularSourceUrl;
	}
}