package com.company.exceptions;

public class NumberDuplicatedException extends RuntimeException {

    public NumberDuplicatedException(String message) {
        super(message);
        System.out.println(message);
    }
}
