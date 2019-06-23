package com.tobioyelami.foodstack.service;

import com.tobioyelami.foodstack.models.FoodItem;
import com.tobioyelami.foodstack.models.Meal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MealService {

    public List<Meal> getSpecialMeals(){
        return getDemoMeal(5);
    }

    public List<Meal> getAvailableMeals(){
        return getDemoMeal(10);
    }

    public List<String> getMealCategoriesList(){
        return Collections.emptyList();
    }

    public List<Meal> getMealByCategories(String categoryName){
        return Collections.emptyList();
    }

    //demo
    private List<Meal> getDemoMeal(int numberOfMeals){
        String[] mealNames = {"Gizdodo", "FruitSalad", "Party Rice", "Jellof Rice", "Fried Rice", "Boli"};
        String[] foodItemNames = {"Meat", "Rosted Plantain ", "Fired Plantain", "Boiled Eggs", "Sauce", "Sliced Onion"};
        String[] drinks = {"Coke Cola", "Pepsi", "Fanta", "Bottled Water", "Juice", "Punch"};

        List<Meal> meals = new ArrayList<>();

        for(int i = 0; i < numberOfMeals; i++){
            int rand = new Random().nextInt(mealNames.length);

            Meal meal = new Meal();
            meal.setName(mealNames[rand]);
            meal.setMain(new FoodItem(mealNames[rand], "Description", "imagePath", 1000));
            meal.setSides(Arrays.asList(new FoodItem(foodItemNames[rand], "Description", "imagePath", 400)));
            meal.setDrinks(Arrays.asList(new FoodItem(drinks[rand], "Description", "imagePath", 100)));

            meals.add(meal);
        }

        return meals;
    }
}
