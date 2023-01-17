package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.services.IngredientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping
@RestController("/ingredients")

public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    Map<Integer, Ingredients> getAll(){
        return this.ingredientService.getAll();
    }
}
