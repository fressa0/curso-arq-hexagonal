package com.example.order;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class OrderResourceTest {
    /*@Test
    void testCreateOrderEndpoint() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = new Order(LocalDateTime.now(), Status.PENDING);
        String json = objectMapper.writeValueAsString(order);

        given()
                .contentType("application/json")
                .body(order)
                .when().post("/orders")
                .then()
                .statusCode(201)
                .body("status", is("PENDING"));
    }*/

}