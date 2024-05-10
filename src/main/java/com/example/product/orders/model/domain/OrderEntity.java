package com.example.product.orders.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50, message = "productName should be between 3 and 50 characters")
    private String productName;

    @NotNull
    @Min(value = 0, message = "Quantity should be greater than 0")
    private Integer quantityOrdered;

    public OrderEntity(String productName, Integer quantityOrdered) {
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
    }
}