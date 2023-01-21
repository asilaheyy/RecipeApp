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
    public ResponseEntity<Ingredients> getAll() {
        ingredientService.getAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{ingredient}")
    public ResponseEntity<Ingredients> getIngredient(@PathVariable Ingredients ingredient){
        Ingredients neededIngredient = ingredientService.getIngredient(ingredient);
        if (neededIngredient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( neededIngredient);

    }

    @PostMapping
    public ResponseEntity<Ingredients> createIngredient(@RequestBody Ingredients ingredient) {
        Ingredients newIngredient = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().body(newIngredient);
    }

    @DeleteMapping("/{ingredient}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Ingredients ingredient) {
        if (ingredientService.deleteIngredient(ingredient)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{ingredient}")
    public ResponseEntity<Ingredients> editIngredient(@PathVariable Ingredients ingredient, @PathVariable String measureUnit, @RequestBody Ingredients ingredients) {
        Ingredients newIngredient = ingredientService.editIngredient(ingredient, measureUnit);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newIngredient);
    }
}
