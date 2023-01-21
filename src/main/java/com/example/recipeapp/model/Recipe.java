package com.example.recipeapp.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor

public class Recipe  {

    private final String recipeName;
    private final int recipeNum;
    private String cookingTime;
    private Set ingredients = new HashSet<Map<String, Ingredients>>();
    private Set cookingSteps = new HashSet<String>();




}
