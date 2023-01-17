package com.example.recipeapp.services;

import com.example.recipeapp.model.Ingredients;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface IngredientService {

    Ingredients addIngredient(Ingredients ingredient);

    Ingredients getIngredient(String ingredient);

    Map<Integer, Ingredients> ingredientsMap = new HashMap<>();
}
