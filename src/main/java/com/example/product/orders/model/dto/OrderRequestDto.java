package com.example.product.orders.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderRequestDto {
    private String productName;
    private Integer quantityOrdered;
}