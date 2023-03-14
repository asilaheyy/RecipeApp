package com.example.recipeapp.service;

import java.io.File;

public interface FileServiceIngredient {

    boolean saveToFileIng(String json);

    String readFromFileIng();
    File getDataFileIng();
    boolean cleanDataFileIng();
}
