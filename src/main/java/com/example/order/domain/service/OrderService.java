package com.example.order.domain.service;

import com.example.order.domain.model.Order;
import com.example.order.domain.model.OrderItem;
import com.example.order.domain.model.valueobjects.Status;
import com.example.order.domain.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Transactional
    public Order createOrder(Order order) {
        orderRepository.persist(order);
        return order;
    }

    @Transactional
    public void addItemsToOrder(Long orderId, List<OrderItem> items) {
        Order order = orderRepository.findById(orderId);
        if (order != null){
            items.forEach(order::addItem);
        }
    }

    @Transactional
    public void updateOrderStatus(Long orderId, Status status) {
        Order order = orderRepository.findById(orderId);
        if (order != null){
            order.updateStatus(status);
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.listAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
