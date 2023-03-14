package com.example.recipeapp.service;

import com.example.recipeapp.model.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;


public abstract interface RecipeService {
    Recipe getRecipeByNum(int recipeNum);


    void addRecipesFromInputStream(MultipartFile file) throws IOException;

    Recipe createRecipe(Recipe recipe);


    boolean deleteRecipe(int recipeNum);

    Recipe editRecipe(int recipeNum, Recipe recipeName);


    TreeMap<Integer, Recipe> getAll();

    TreeMap<Integer, Recipe> recipesMap = new TreeMap<>();

    ObjectMapper objectMapper = new ObjectMapper();
}


