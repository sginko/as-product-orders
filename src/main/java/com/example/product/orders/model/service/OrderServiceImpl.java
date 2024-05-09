package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.OrderEntity;
import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.OrderRequestDto;
import com.example.product.orders.model.mapper.OrderMapper;
import com.example.product.orders.model.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productService = productService;
    }

    @Override
    @Transactional
    public void addOrder(OrderRequestDto orderRequestDto) {
        OrderEntity orderEntity = productService.findByName(orderRequestDto.getProductName())
                .map(productEntity -> {
                    productEntity.updateProduct(orderMapper.toEntity(orderRequestDto));
                    return orderMapper.toEntity(orderRequestDto);
                })
                .orElseThrow(() -> new ServiceException("Not found product"));
        orderRepository.save(orderEntity);
    }
}
