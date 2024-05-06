package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> findALLpProducts();
    ProductEntity addProduct(ProductEntity productEntity);
}
