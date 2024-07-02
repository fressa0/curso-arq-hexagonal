package com.example.order.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jboss.logging.annotations.ValidIdRange;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private int quantity;

    private BigDecimal price;

    public OrderItem(String product, int quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }



}
