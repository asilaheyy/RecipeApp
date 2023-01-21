package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.service.RecipeService;
import com.example.recipeapp.service.RecipeService;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Recipe> getAllRecipes() {
        recipeService.getAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{recipeNum}")
    public ResponseEntity<Recipe> getRecipeByNum(int recipeNum) {
        Recipe recipeByNum = recipeService.getRecipeByNum(recipeNum);
        if (recipeByNum == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeByNum);

    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.createRecipe(recipe);
        return ResponseEntity.ok().body(newRecipe);
    }

    @DeleteMapping("/{recipeNum}")
    public ResponseEntity<Void> deleteRecipeByNum(@PathVariable int recipeNum) {
        if (recipeService.deleteRecipe(recipeNum)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{recipeNum}")
    public ResponseEntity<Recipe> editRecipeByNum(@PathVariable int recipeNum, @RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.editRecipe(recipeNum, recipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newRecipe);
    }

}


