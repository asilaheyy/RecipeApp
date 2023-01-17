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

    private final String recipeName;
    private final int recipeNum;
    private int cookingTime;
    private Set ingredients = new HashSet<Ingredients>();
    private Set cookingSteps = new HashSet<String>();

    private Map<Integer, Recipe> recipesMap = new HashMap<>();

}
