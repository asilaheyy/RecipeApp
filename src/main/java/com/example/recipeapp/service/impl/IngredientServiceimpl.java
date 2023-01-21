package com.example.recipeapp.service.impl;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceimpl implements IngredientService {

    private static Map<Ingredients, String> ingredientsMap = new HashMap<>();

    @Override
    public Ingredients addIngredient(Ingredients ingredient) {
        if (ingredientsMap.containsKey(ingredient)) {
            return null;
        } else {
            ingredientsMap.put(ingredient, ingredient.getMeasureUnit());
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
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public Map<Ingredients, String> getAll() {
        return ingredientsMap;
    }
}
