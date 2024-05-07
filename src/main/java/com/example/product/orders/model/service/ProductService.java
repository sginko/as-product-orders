package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    void addProduct(ProductRequestDto productRequestDto);
    List<ProductResponseDto> findAllProducts();
}
