package com.example.recipeapp.model;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {

    private String ingredientName;
    private String measureUnit;

}
