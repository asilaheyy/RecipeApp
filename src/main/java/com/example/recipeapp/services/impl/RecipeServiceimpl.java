package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.RecipeService;
import com.example.recipeapp.services.IngredientService;

import java.util.Map;

public class RecipeServiceimpl implements RecipeService {


    int counter =0;


    @Override
    public Recipe getRecipeByNum(int recipeNum) {
       for (Map.Entry<Integer,Recipe> recipes : recipesMap.entrySet()){
           if(recipesMap.containsKey(recipeNum)){
               recipesMap.get(recipeNum);
           }
       }
       return null;

    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        Map<Integer, Recipe> newRecipe = (Map<Integer, Recipe>) recipesMap.put(counter++, recipe);
        recipesMap.put(counter++,recipe);
        if(newRecipe == null){
            return null;
        }
        return recipe;

    }
}
