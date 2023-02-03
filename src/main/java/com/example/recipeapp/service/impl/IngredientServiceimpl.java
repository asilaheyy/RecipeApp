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

    private static TreeMap<Ingredients, String> ingredientsMap = new TreeMap<>();

    public IngredientServiceimpl(FileServiceIngredient fileServiceIngredient) {
        this.fileServiceIngredient = fileServiceIngredient;
    }


    @PostConstruct
    private void initIngredient(){
        readFromFileIngredient();
    }

    @Override
    public Ingredients addIngredient(Ingredients ingredient) {
        if (ingredientsMap.containsKey(ingredient)) {
            return null;
        } else {
            ingredientsMap.put(ingredient, ingredient.getMeasureUnit());
            saveToFileIngredient();
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
        for (Ingredients ingredient : ingredientsMap.keySet()) {
            if (ingredientsMap.containsKey(ingredient)) {
                ingredientsMap.remove(ingredient);
                return true;
            }
        }
        return false;
    }

    @Override
    public Ingredients editIngredient(Ingredients ingredients, String measureUnit) {
        for (Ingredients ingredient : ingredientsMap.keySet()) {
            if (ingredientsMap.containsKey(ingredient)) {
                ingredientsMap.put(ingredient, measureUnit);
                saveToFileIngredient();
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public TreeMap<Ingredients, String> getAll() {
        return ingredientsMap;
    }

    private void saveToFileIngredient(){
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientsMap);
            fileServiceIngredient.saveToFileIngredient(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFileIngredient(){
        String json = fileServiceIngredient.readFromFileIngredient();
        try {
            ingredientsMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Ingredients, String>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
