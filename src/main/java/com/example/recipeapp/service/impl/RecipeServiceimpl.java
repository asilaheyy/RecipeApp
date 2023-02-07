package com.example.recipeapp.service.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.service.FileService;
import com.example.recipeapp.service.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;

@Service
public class RecipeServiceimpl implements RecipeService {

    final private FileService fileService;

    private static TreeMap<Integer, Recipe> recipesMap = new TreeMap<Integer, Recipe>();

    int counter = 0;

    public RecipeServiceimpl(FileService fileService) {
        this.fileService = fileService;
    }

    @PostConstruct
    private void init(){
        readFromFile();
    }

    @Override
    public Recipe getRecipeByNum(int recipeNum) {
        if (recipesMap.containsKey(recipeNum)) {
            return recipesMap.get(recipeNum);
        } else {
            return null;
        }
    }

    @Override
    public void addRecipesFromInputStream(InputStream inputStream) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = StringUtils.split(line, '|');
                Recipe recipe = new Recipe(String.valueOf(array[0]), Integer.parseInt(array[1]), String.valueOf(array[2]), Set.of(array[3]), Set.of(array[4]));
                createRecipe(recipe);
            }
        }
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        if (recipesMap.containsKey(recipe.getRecipeNum())) {
            return null;
        } else {
            recipesMap.put(recipe.getRecipeNum(), recipe);
            saveToFile();
            counter++;
            return recipe;
        }
    }

    @Override
    public boolean deleteRecipe(int recipeNum) {
            if (recipesMap.containsKey(recipeNum)) {
                recipesMap.remove(recipeNum);
                saveToFile();
                return true;
            }
        return false;
    }

    @Override
    public Recipe editRecipe(int recipeNum, Recipe recipeName) {
            if (recipesMap.containsKey(recipeNum)) {
                recipesMap.put(recipeNum, recipeName);
                saveToFile();
                return recipeName;
            }
        return null;
    }

    @Override
    public TreeMap<Integer, Recipe> getAll() {
        return recipesMap;
    }

    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(recipesMap);
            fileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile(){
        String json = fileService.readFromFile();
        try {
           recipesMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer,Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
