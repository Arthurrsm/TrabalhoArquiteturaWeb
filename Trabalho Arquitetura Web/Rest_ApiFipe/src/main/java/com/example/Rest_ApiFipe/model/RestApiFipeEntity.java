package com.example.Rest_ApiFipe.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "api-fipe")

public class RestApiFipeEntity {

    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
