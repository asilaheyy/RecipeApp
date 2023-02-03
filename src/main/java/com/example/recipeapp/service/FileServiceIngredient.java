package com.example.recipeapp.service;

public interface FileServiceIngredient {

    boolean saveToFileIngredient(String json);

    String readFromFileIngredient();
}
