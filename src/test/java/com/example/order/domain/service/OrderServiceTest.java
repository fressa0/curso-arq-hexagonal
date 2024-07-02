package com.example.order.domain.service;

import com.example.order.domain.model.Order;
import com.example.order.domain.model.OrderItem;
import com.example.order.domain.model.valueobjects.Status;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class OrderServiceTest {

    @Inject
    OrderService orderService;

    @Test
    public void testCreateOrder() {
        Order order = new Order(LocalDateTime.now(), Status.PENDING);
        orderService.createOrder(order);
        assertNotNull(order.getId());
    }

    @Test
    public void testAddItemsToOrder() {
        Order order = new Order(LocalDateTime.now(), Status.PENDING);
        orderService.createOrder(order);
        assertNotNull(order.getId());
        OrderItem item = new OrderItem("PRODUCT 1", 10, BigDecimal.TEN);
        orderService.addItemsToOrder(order.getId(), List.of(item));
        assertEquals(1, orderService.getOrderById(order.getId()).getItems().size());
    }

    @Test
    public void testUpdateOrderStatus() {
        Order order = new Order(LocalDateTime.now(), Status.PENDING);
        orderService.createOrder(order);
        assertNotNull(order.getId());
        orderService.updateOrderStatus(order.getId(), Status.DELIVERED);
        assertEquals(Status.DELIVERED, orderService.getOrderById(order.getId()).getStatus());
    }

}
