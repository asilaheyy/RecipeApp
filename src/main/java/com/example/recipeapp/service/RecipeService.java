package com.example.recipeapp.service;

import com.example.recipeapp.model.Recipe;


import java.util.TreeMap;


public abstract interface RecipeService {
    Recipe getRecipeByNum(int recipeNum);


    Recipe createRecipe(Recipe recipe);


    boolean deleteRecipe(int recipeNum);

    Recipe editRecipe(int recipeNum, Recipe recipeName);


    TreeMap<Integer, Recipe> getAll();

    TreeMap<Integer, Recipe> recipesMap = new TreeMap<>();
}
