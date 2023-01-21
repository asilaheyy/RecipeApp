package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController("/ingredients")
@RequestMapping
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    Map<Ingredients, String> getAll() {
        return this.ingredientService.getAll();
    }

    @PostMapping
    public Ingredients createIngredient(@RequestBody Ingredients ingredient) {
        return this.ingredientService.addIngredient(ingredient);
    }

    @DeleteMapping("/{ingredient}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Ingredients ingredient) {
        if (ingredientService.deleteIngredient(ingredient)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{ingredient}")
    public ResponseEntity<Ingredients> editIngredientMeasureUnit(@PathVariable Ingredients ingredient, @RequestBody Ingredients ingredients) {
        Ingredients newIngredient = ingredientService.editIngredient(ingredient, ingredients.getMeasureUnit());
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newIngredient);
    }
}
