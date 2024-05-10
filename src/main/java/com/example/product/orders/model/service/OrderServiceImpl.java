package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.OrderEntity;
import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.OrderRequestDto;
import com.example.product.orders.model.dto.OrderResponseDto;
import com.example.product.orders.model.mapper.OrderMapper;
import com.example.product.orders.model.mapper.ProductMapper;
import com.example.product.orders.model.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductService productService;
    private final ProductMapper productMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper,
                            ProductService productService, ProductMapper productMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public void addOrder(OrderRequestDto orderRequestDto) {
        OrderEntity orderEntity = productService.findByName(orderRequestDto.getProductName())
                .map(productEntity -> {
                    productEntity.updateProduct(orderMapper.toEntity(orderRequestDto));
                    deleteEmptyProduct(productEntity);
                    return orderMapper.toEntity(orderRequestDto);
                })
                .orElseThrow(() -> new ServiceException("Not found product"));
        orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderResponseDto> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderEntity -> orderMapper.fromEntity(orderEntity))
                .toList();
    }

    private void deleteEmptyProduct(ProductEntity productEntity) {
        if (productEntity.checkProductQuantity()){
            productService.deleteProduct(productEntity);
        }
    }
}