package com.example.ClimaApi.controller;

import com.example.ClimaApi.service.ClimaApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ClimaApiController {
    @Autowired
    private ClimaApiService service;

    @GetMapping("/clima")
    public String preverTempo(){return service.preverTempo();}
}
