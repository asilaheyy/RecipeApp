package com.example.recipeapp.service;

import com.example.recipeapp.model.Recipe;


import java.util.HashMap;
import java.util.Map;


public abstract interface RecipeService {
    Recipe getRecipeByNum(int recipeNum);


    Recipe createRecipe(Recipe recipe);

    boolean deleteRecipe(int recipeNum);

    Recipe editRecipe(int recipeNum, Recipe recipe);

    Map<Integer, Recipe> getAll();

    Map<Integer, Recipe> recipesMap = new HashMap<>();
}
