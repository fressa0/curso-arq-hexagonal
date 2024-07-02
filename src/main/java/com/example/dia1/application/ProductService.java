package com.example.dia1.application;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService {
    public String getProducts() {
        return "Listado de productos 01-07-2024";
    }
}
