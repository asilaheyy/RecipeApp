package com.example.recipeapp.service;

import com.example.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service

public interface RecipeService {
    Recipe getRecipeByNum(int recipeNum);

    Recipe addRecipe(Recipe recipe);
    Map<Integer, Recipe> getAll();

    Map<Integer, Recipe> recipesMap = new HashMap<>();
}
