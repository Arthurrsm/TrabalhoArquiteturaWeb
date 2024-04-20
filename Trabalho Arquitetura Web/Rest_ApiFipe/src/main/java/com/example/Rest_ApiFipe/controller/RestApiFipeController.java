package com.example.Rest_ApiFipe.controller;

import com.example.Rest_ApiFipe.service.RestApiFipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiFipeController {


    @Autowired
    private RestApiFipeService service;

    @GetMapping("/marcas")
    public String consultarMarcas() {
        return service.consultarMarcas();
    }
}