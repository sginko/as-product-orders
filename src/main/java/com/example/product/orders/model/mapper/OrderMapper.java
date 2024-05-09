package com.example.product.orders.model.mapper;

import com.example.product.orders.model.domain.OrderEntity;
import com.example.product.orders.model.dto.OrderRequestDto;
import com.example.product.orders.model.dto.OrderResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final ModelMapper modelMapper;

    public OrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderResponseDto fromEntity(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderResponseDto.class);
    }

    public OrderEntity toEntity(OrderRequestDto orderRequestDto) {
        return modelMapper.map(orderRequestDto, OrderEntity.class);
    }
}