package com.example.recipeapp.service;

import com.example.recipeapp.model.Ingredients;


import java.util.HashMap;
import java.util.Map;


public abstract interface IngredientService {

    Ingredients addIngredient(Ingredients ingredient);
    Ingredients getIngredient(Ingredients ingredient);

    Map<Ingredients, String> ingredientsMap = new HashMap<>();

    boolean deleteIngredient(Ingredients ingredient);

    Ingredients editIngredient(Ingredients ingredients, String measureUnit);

    Map<Ingredients, String> getAll();

}
