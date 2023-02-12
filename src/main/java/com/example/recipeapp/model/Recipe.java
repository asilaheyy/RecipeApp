package com.example.recipeapp.model;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe  {

    private String recipeName;
    private int recipeNum;
    private String cookingTime;
    private Set ingredients = new HashSet<Map<String, Ingredients>>();
    private Set cookingSteps = new HashSet<String>();
    ObjectMapper objectMapper;



}
