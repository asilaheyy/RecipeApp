package com.example.recipeapp.model;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor

public class Ingredients {

    String ingredient;
    int ingredientCount;
    String measureUnit;
}
