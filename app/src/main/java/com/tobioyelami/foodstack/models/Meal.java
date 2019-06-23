package com.tobioyelami.foodstack.models;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String name;
    private String imageUrl;
    private double cost;
    private FoodItem main;
    private List<FoodItem> sides;
    private List<FoodItem> drinks;
    private List<FoodItem> proteins;
    private int packageCount;

    public Meal() {
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public FoodItem getMain() {
        return main;
    }

    public void setMain(FoodItem main) {
        this.main = main;
    }

    public List<FoodItem> getSides() {
        return sides;
    }

    public void setSides(List<FoodItem> sides) {
        this.sides = sides;
    }

    public List<FoodItem> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<FoodItem> drinks) {
        this.drinks = drinks;
    }

    public List<FoodItem> getProteins() {
        return proteins;
    }

    public void setProteins(List<FoodItem> proteins) {
        this.proteins = proteins;
    }

    public int getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }
    public double getCost(){
        if(this.cost != 0){
            return cost;
        }
        List<FoodItem> all = new ArrayList<>();
        all.add(main);
        if(sides != null && !sides.isEmpty())
            all.addAll(sides);
        if(drinks != null && !drinks.isEmpty())
            all.addAll(drinks);
        if(proteins != null && !proteins.isEmpty())
            all.addAll(proteins);

        double total = 0d;
        for(FoodItem FoodItem: all){
            total += FoodItem.getPrice();
        }
        return total;
    }

}
