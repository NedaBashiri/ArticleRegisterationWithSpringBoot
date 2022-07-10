package com.example.articleregisterationwithspringboot.exception;

public final class InValidDataException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InValidDataException() {
        super();
    }

    public InValidDataException(final String message) {
        super(message);
    }

    public InValidDataException(final String message, final Throwable cause) {
        super(message, cause);
    }
}