package com.example.recipeapp.model;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {

    private Ingredients ingredient;
    private String measureUnit;

}
