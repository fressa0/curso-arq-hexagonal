package com.example.order.domain.model;

import com.example.order.domain.model.valueobjects.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Order\"")
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Order(LocalDateTime creationDate, Status status) {
        this.creationDate = creationDate;
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

}
