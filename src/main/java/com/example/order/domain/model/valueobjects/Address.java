package com.example.order.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
        private String street;
        private String city;
        private String zipCode;
}
