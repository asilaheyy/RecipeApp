package com.example.recipeapp.service.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.service.RecipeService;

import java.util.Map;

public class RecipeServiceimpl implements RecipeService {

    int counter =0;

    @Override
    public Recipe getRecipeByNum(int recipeNum) {
        if(recipesMap.containsKey(recipeNum)){
            return recipesMap.get(recipeNum);
        }
        else {
            throw new RuntimeException("Нет такого рецепта");
        }
    }
    @Override
    public Recipe addRecipe(Recipe recipe) {
        if(recipesMap.containsKey(recipe.getRecipeNum())){
            throw new RuntimeException("Такой рецепт уже существует");
        }
        else {
            recipesMap.put(recipe.getRecipeNum(), recipe);
        }
        return recipe;
    }

    @Override
    public Map<Integer, Recipe> getAll() {
        return recipesMap;
    }

}
