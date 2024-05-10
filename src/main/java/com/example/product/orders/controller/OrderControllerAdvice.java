package com.example.product.orders.controller;

import com.example.product.orders.model.service.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderControllerAdvice {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ErrorResponse> handlerJokeServiceException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
    }

    @Getter
    @AllArgsConstructor
    class ErrorResponse{
        private String reasons;
    }
}