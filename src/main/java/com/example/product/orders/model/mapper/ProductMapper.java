package com.example.product.orders.model.mapper;

import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.dto.ProductResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductResponseDto fromEntity(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductResponseDto.class);
    }

    public ProductEntity toEntity(ProductRequestDto productRequestDto) {
        return modelMapper.map(productRequestDto, ProductEntity.class);
    }
}
