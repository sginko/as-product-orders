package com.example.product.orders.controller;

import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.dto.ProductResponseDto;
import com.example.product.orders.model.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ProductRequestDto addProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.addProduct(productRequestDto);
        return productRequestDto;
    }

    @GetMapping
    public List<ProductResponseDto> findAllProducts(){
        return productService.findAllProducts();
    }
}