package com.example.product.orders.controller;

import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.dto.ProductResponseDto;
import com.example.product.orders.model.mapper.ProductMapper;
import com.example.product.orders.model.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping("/add_product")
    public ProductRequestDto addProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.addProduct(productMapper.toEntity(productRequestDto));
        return productRequestDto;
    }

    @GetMapping
    public List<ProductResponseDto> findAllProduct(){
        return productService.findALLpProducts().stream()
                .map(productEntity -> productMapper.fromEntity(productEntity))
                .toList();
    }
}
