package com.example.product.orders.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponseDto {
    private String productName;
    private Integer quantityOrdered;
}