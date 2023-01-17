package com.example.recipeapp.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Recipe {

    String recipeName;
    int cookingTime;
    Set ingredients = new HashSet<Ingredients>();
    Set cookingSteps = new HashSet<String>();

    Map<Integer, Recipe> recipesMap = new HashMap<>();

}
