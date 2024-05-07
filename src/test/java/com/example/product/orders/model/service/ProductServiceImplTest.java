package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.mapper.ProductMapper;
import com.example.product.orders.model.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ProductMapper productMapper = new ProductMapper(modelMapper);

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    void addProduct() {
        //given
        ProductRequestDto productRequestDto = new ProductRequestDto("Test", 3);

        //when
        ProductEntity productEntity = productService.addProduct(productRequestDto);

        //then
        List<ProductEntity> all = productRepository.findAll();
        assertEquals(all.size(), 1);
        assertEquals(productEntity, all.get(0));
    }
}
