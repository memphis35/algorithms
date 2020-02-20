package com.company.exceptions;

public class NotExistException extends RuntimeException {
    public NotExistException(String s) {
        super(s);
    }
}
