package com.example.recipeapp.model;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Ingredients {

    private final Ingredients ingredient;
    private int ingredientCount;
    private String measureUnit;

}
