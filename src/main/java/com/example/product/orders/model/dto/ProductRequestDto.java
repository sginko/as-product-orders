package com.example.product.orders.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRequestDto {
    private String name;
    private Integer quantity;
}
