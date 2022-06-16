package com.interview.unicorn.exception;

public class UnicornNotFoundException extends RuntimeException{

    public UnicornNotFoundException() {
        super("No unicorns are found");
    }

    public UnicornNotFoundException(Integer id) {
        super(String.format("No matching unicorn found with id %d", id));
    }
}
