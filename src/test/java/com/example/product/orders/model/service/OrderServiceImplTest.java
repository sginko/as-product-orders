package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.OrderEntity;
import com.example.product.orders.model.dto.OrderRequestDto;
import com.example.product.orders.model.dto.OrderResponseDto;
import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.dto.ProductResponseDto;
import com.example.product.orders.model.repository.OrderRepository;
import com.example.product.orders.model.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class OrderServiceImplTest {
    private final static String PRODUCT_NAME = "Test";
    private final static String FALSE_PRODUCT_NAME = "False";
    private final static Integer QUANTITY_ORDERED = 3;
    private final static Integer PRODUCT_QUANTITY = 3;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    void should_add_order_correctly() {
        //given
        ProductRequestDto productRequestDto = new ProductRequestDto(PRODUCT_NAME, PRODUCT_QUANTITY);
        productService.addProduct(productRequestDto);
        OrderRequestDto orderRequestDto = new OrderRequestDto(PRODUCT_NAME, QUANTITY_ORDERED);

        //when
        orderService.addOrder(orderRequestDto);

        //then
        List<OrderEntity> all = orderRepository.findAll();
        assertEquals(all.size(), 1);
        assertThat(all.get(0).getProductName()).isEqualTo(PRODUCT_NAME);
        assertThat(all.get(0).getQuantityOrdered()).isEqualTo(QUANTITY_ORDERED);
    }

    @Test
    void should_throw_correctly_when_product_not_exist() {
        //given
        ProductRequestDto productRequestDto = new ProductRequestDto(PRODUCT_NAME, PRODUCT_QUANTITY);
        productService.addProduct(productRequestDto);
        OrderRequestDto orderRequestDto = new OrderRequestDto(FALSE_PRODUCT_NAME, QUANTITY_ORDERED);

        //when
        Executable e = () -> orderService.addOrder(orderRequestDto);

        //then
        assertThrows(ServiceException.class, e);
    }

    @Test
    void should_find_all_orders_correctly() {
        //given
        ProductRequestDto productRequestDto = new ProductRequestDto(PRODUCT_NAME, PRODUCT_QUANTITY);
        productService.addProduct(productRequestDto);
        OrderRequestDto orderRequestDto = new OrderRequestDto(PRODUCT_NAME, QUANTITY_ORDERED);
        orderService.addOrder(orderRequestDto);

        //when
        List<OrderResponseDto> allOrders = orderService.findAllOrders();

        //then
        assertEquals(allOrders.size(), 1);
        assertThat(allOrders.get(0).getProductName()).isEqualTo(PRODUCT_NAME);
        assertThat(allOrders.get(0).getQuantityOrdered()).isEqualTo(QUANTITY_ORDERED);
    }
}