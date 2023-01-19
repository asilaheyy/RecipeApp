package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.service.RecipeService;
import com.example.recipeapp.service.RecipeService;

import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public Map<Integer, Recipe> getAll() {
        return this.recipeService.getAll();
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe){
        return this.recipeService.addRecipe(recipe);
    }

}


