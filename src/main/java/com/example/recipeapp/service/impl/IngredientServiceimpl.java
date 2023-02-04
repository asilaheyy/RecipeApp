package com.example.recipeapp.service.impl;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.service.FileServiceIngredient;
import com.example.recipeapp.service.IngredientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.TreeMap;

@Service
public class IngredientServiceimpl implements IngredientService {

    final private FileServiceIngredient fileServiceIngredient;

    private static TreeMap<String, String> ingredientsMap = new TreeMap<String, String>();

    public IngredientServiceimpl(FileServiceIngredient fileServiceIngredient) {
        this.fileServiceIngredient = fileServiceIngredient;
    }


    @PostConstruct
    private void initIng(){
        readFromFileIng();
    }

    @Override
    public String addIngredient(String ingredient, String measureUnit) {
        if (ingredientsMap.containsKey(ingredient)) {
            return null;
        } else {
            ingredientsMap.put(ingredient, measureUnit);
            saveToFileIng();
        }
        return ingredient;
    }

    @Override
    public Ingredients getIngredient(Ingredients ingredient) {
        if (ingredientsMap.containsKey(ingredient)) {
            return ingredient;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteIngredient(Ingredients ingredients) {
        for (String ingredient : ingredientsMap.keySet()) {
            if (ingredientsMap.containsKey(ingredient)) {
                ingredientsMap.remove(ingredient);
                return true;
            }
        }
        return false;
    }

    @Override
    public String editIngredient(Ingredients ingredients, String measureUnit) {
        for (String ingredient : ingredientsMap.keySet()) {
            if (ingredientsMap.containsKey(ingredient)) {
                ingredientsMap.put(ingredient, measureUnit);
                saveToFileIng();
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public TreeMap<String, String> getAll() {
        return ingredientsMap;
    }

    private void saveToFileIng(){
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientsMap);
            fileServiceIngredient.saveToFileIng(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFileIng(){
        String json = fileServiceIngredient.readFromFileIng();
        try {
            ingredientsMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<String, String>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
