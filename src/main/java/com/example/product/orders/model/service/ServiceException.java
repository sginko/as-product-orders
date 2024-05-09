package com.example.product.orders.model.service;

public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}