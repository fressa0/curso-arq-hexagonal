package com.example.dia1.infrastructure;

import com.example.dia1.application.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/products")
public class ProductResource {

    private final ProductService productService;

    @Inject
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getProducts() {
        return productService.getProducts();
    }

}
