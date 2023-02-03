package com.example.recipeapp.service;

public interface FileService {

    boolean saveToFile(String json);

    String readFromFile();
}
