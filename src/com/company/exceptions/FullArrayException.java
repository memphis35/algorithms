package com.company.exceptions;

public class FullArrayException extends RuntimeException {

    public FullArrayException(String message) {
        super(message);
        System.out.println(message);
    }
}
