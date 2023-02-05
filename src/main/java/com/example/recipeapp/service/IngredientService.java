package com.example.recipeapp.service;

import com.example.recipeapp.model.Ingredients;


import java.util.HashMap;
import java.util.Map;


public abstract interface IngredientService {


    String addIngredient(String ingredient, String measureUnit);

    Ingredients getIngredient(Ingredients ingredient);

    Map<String, String> ingredientsMap = new HashMap<>();

    boolean deleteIngredient(Ingredients ingredient);

    String editIngredient(String ingredient, String measureUnit);

    Map<String, String> getAll();

}
