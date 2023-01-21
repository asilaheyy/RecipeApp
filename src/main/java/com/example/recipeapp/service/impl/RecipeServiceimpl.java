package com.example.recipeapp.service.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceimpl implements RecipeService {
    private static Map<Integer, Recipe> recipesMap = new HashMap<>();

    int counter = 0;

    @Override
    public Recipe getRecipeByNum(int recipeNum) {
        if (recipesMap.containsKey(recipeNum)) {
            return recipesMap.get(recipeNum);
        } else {
            return null;
        }
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        if (recipesMap.containsKey(recipe.getRecipeNum())) {
            return null;
        } else {
            recipesMap.put(recipe.getRecipeNum(), recipe);
        }
        return recipe;
    }

    @Override
    public boolean deleteRecipe(int recipeNum) {
        for (Recipe recipes : recipesMap.values()) {
            if (recipesMap.containsKey(recipeNum)) {
                recipesMap.remove(recipeNum);
                return true;
            }
        }
        return false;
    }

    @Override
    public Recipe editRecipe(int recipeNum, Recipe recipes) {
        for (Recipe recipe : recipesMap.values()) {
            if (recipesMap.containsKey(recipeNum)) {
                recipesMap.put(recipeNum, recipe);
                return recipe;
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Recipe> getAll() {
        return recipesMap;
    }

}
