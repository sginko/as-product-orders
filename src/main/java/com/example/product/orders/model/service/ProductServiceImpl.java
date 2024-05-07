package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.mapper.ProductMapper;
import com.example.product.orders.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

//    @Override
//    public List<ProductEntity> findALLpProducts() {
//        return productRepository.findAll();
//    }

    @Override
    public ProductEntity addProduct(ProductRequestDto productRequestDto) {
        return productRepository.save(productMapper.toEntity(productRequestDto));
    }
}
