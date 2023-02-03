package com.example.recipeapp.service.impl;

import com.example.recipeapp.service.FileServiceIngredient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceimplIngredient implements FileServiceIngredient {

    @Value("${path.to.data.file}")
    private String dataFilePathIng;

    @Value("${name.of.data.file}")
    private String dataFileNameIng;



    @Override
    public boolean saveToFileIngredient(String json) {
        try {
            cleanDataFileIngredient();
            Files.writeString(Path.of(dataFilePathIng, dataFileNameIng),json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readFromFileIngredient() {
        try {
            return Files.readString(Path.of(dataFilePathIng, dataFileNameIng));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean cleanDataFileIngredient() {
        try {
            Path path = Path.of(dataFilePathIng, dataFileNameIng);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

