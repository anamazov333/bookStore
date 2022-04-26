package com.company.bookstore.exception;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String message) {
        super(message);
    }

}
