package com.apimarket.market.domain.exception;


public class ProductoException extends RuntimeException {

    public ProductoException(String message) {
        super(String.valueOf(message));
    }
}
