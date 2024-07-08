package com.example.hexagonal.core.adapters.primary.rest;

import com.example.hexagonal.core.domain.service.OrderService;
import com.example.hexagonal.core.domain.entity.Customer;
import com.example.hexagonal.core.domain.entity.Order;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
class OrderResourceTest {

    @Mock
    OrderService orderService;

    @InjectMocks
    OrderResource orderResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RestAssured.config = RestAssured.config();
    }

    @Test
    void testCreateOrder() {
        Customer customer = new Customer("John", "Doe");
        Order order = new Order("Test Order", LocalDateTime.now(), customer);
        when(orderService.createOrder(order)).thenReturn(order);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(order)
                .when()
                .post("/orders")
                .then()
                .statusCode(201)
                .body("description", is("Test Order"));
    }

    @Test
    void testGetOrder() {
        Customer customer = new Customer("John", "Doe");
        Order order = new Order("Test Order", LocalDateTime.now(), customer);
        when(orderService.getOrder(1L)).thenReturn(Optional.of(order));

        given()
                .pathParam("id", 1L)
                .when()
                .get("/orders/{id}")
                .then()
                .statusCode(200)
                .body("description", is("Test Order"));
    }

    @Test
    void testGetAllOrders() {
        // similar to above, test for getAllOrders()
    }

    @Test
    void testDeleteOrder() {
        given()
                .pathParam("id", 1L)
                .when()
                .delete("/orders/{id}")
                .then()
                .statusCode(204);
    }
}