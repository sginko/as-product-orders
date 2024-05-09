package com.example.product.orders.model.service;

import com.example.product.orders.model.dto.OrderRequestDto;
import com.example.product.orders.model.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void addOrder(OrderRequestDto orderRequestDto);
}