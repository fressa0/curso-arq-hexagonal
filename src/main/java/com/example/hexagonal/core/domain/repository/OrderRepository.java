package com.example.hexagonal.core.domain.repository;

import com.example.hexagonal.core.domain.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void deleteById(Long id);

}
