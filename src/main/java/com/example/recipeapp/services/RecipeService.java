package com.example.recipeapp.services;

import com.example.recipeapp.model.Recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public interface RecipeService {

    Recipe getRecipeByNum(int recipeNum);

    Recipe addRecipe(Recipe recipe);

     Map<Integer, Recipe> recipesMap = new TreeMap<>();


}
