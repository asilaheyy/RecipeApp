package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.service.IngredientService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Ingredients createIngredient(@RequestBody Ingredients ingredient){
        return this.ingredientService.addIngredient(ingredient);
    }
}
