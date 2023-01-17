package com.example.recipeapp.services;

import com.example.recipeapp.model.Ingredients;

import java.util.HashMap;
import java.util.Map;

public interface IngredientService {

    Ingredients addIngredient(Ingredients ingredient);

    Ingredients getIngredient(String ingredient);

    Map<Integer, Ingredients> ingredietsMap = new HashMap<>();
}
