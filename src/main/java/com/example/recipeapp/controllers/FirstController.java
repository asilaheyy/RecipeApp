package com.example.recipeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String helloWorld(){
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info(){
        return "Алиса. Приложение для рецептов. Создано 16.12.2022";

    }

}
