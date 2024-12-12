package com.example.culinarycompass.recyclerview;

import java.util.List;

public class RecipeData {
    private int id;
    private String image;
    private String title;
    private String summary;
    private String servingTime;
    private String servingJumlah;
    private List<String> instructions;
    public RecipeData() {
    }
    public RecipeData(int id, String image, String title, String summary, String servingTime, String servingJumlah,List<String> instructions ) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.summary = summary;
        this.servingTime = servingTime;
        this.servingJumlah = servingJumlah;
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getServingTime() {
        return servingTime;
    }

    public void setServingTime(String servingTime) {
        this.servingTime = servingTime;
    }

    public String getServingJumlah() {
        return servingJumlah;
    }

    public void setServingJumlah(String servingJumlah) {
        this.servingJumlah = servingJumlah;
    }



}
