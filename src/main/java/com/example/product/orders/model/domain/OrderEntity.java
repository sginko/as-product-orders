package com.example.product.orders.model.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(unique = true)
    private String productName;

    private Integer quantityOrdered;

    public OrderEntity(String productName, Integer quantityOrdered) {
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
    }
}
