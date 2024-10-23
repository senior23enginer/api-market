package com.apimarket.market.domain.exception;


public class SucursalException extends RuntimeException {

    public SucursalException(String message) {
        super(String.valueOf(message));
    }
}
