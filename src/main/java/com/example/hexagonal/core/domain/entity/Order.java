package com.example.hexagonal.core.domain.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"Order\"")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String description;

    private LocalDateTime creationDate;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(String description, LocalDateTime creationDate, Customer customer) {
        this.description = description;
        this.creationDate = creationDate;
        this.customer = customer;
    }

}
