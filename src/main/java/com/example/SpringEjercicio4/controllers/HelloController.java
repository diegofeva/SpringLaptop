package com.example.SpringEjercicio4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("api/saludo")
    public String saludo(){
        String saludo = "Hola gente";
        return saludo;
    }
}
