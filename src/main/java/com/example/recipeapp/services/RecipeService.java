package com.example.recipeapp.services;

import com.example.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@Service
public interface RecipeService {

    Recipe getRecipeByNum(int recipeNum);

    Recipe addRecipe(Recipe recipe);

    Map<Integer, Recipe> recipesMap = new TreeMap<>();


}
