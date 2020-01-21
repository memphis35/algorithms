package com.company.exceptions;

public class NumberNotFoundException extends RuntimeException {

    public NumberNotFoundException(String message) {
        super(message);
        System.out.println(message);
    }

}
