package com.tca.exception;

public class BookAlreadyExitsException extends RuntimeException{

    public BookAlreadyExitsException(String message) {
        super(message);
    }
}
