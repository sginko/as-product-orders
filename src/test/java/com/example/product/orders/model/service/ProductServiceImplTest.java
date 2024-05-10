package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.dto.ProductResponseDto;
import com.example.product.orders.model.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceImplTest {
    private final static String NAME = "Test";
    private final static Integer QUANTITY = 3;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    void should_add_product_correctly() {
        //given
        ProductRequestDto productRequestDto = new ProductRequestDto(NAME, QUANTITY);

        //when
        productService.addProduct(productRequestDto);

        //then
        List<ProductEntity> all = productRepository.findAll();
        assertEquals(all.size(), 1);
        assertThat(all.get(0).getName()).isEqualTo(NAME);
        assertThat(all.get(0).getQuantity()).isEqualTo(QUANTITY);
    }

    @Test
    void should_find_all_products_correctly() {
        //given
        ProductRequestDto productRequestDto = new ProductRequestDto(NAME, QUANTITY);
        productService.addProduct(productRequestDto);

        //when
        List<ProductResponseDto> allProducts = productService.findAllProducts();

        //then
        assertThat(allProducts.get(0).getName()).isEqualTo(NAME);
        assertThat(allProducts.get(0).getQuantity()).isEqualTo(QUANTITY);
        assertThat(allProducts.size()).isEqualTo(1);
    }
}
