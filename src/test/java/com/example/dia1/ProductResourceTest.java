package com.example.dia1;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ProductResourceTest {
    @Test
    void testResourceEndpoint() {
        given()
          .when().get("/products")
          .then()
             .statusCode(200)
             .body(is("Listado de productos 01-07-2024"));
    }

}