package com.example.product.orders.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String productName;

    private Integer quantityOrdered;
}
