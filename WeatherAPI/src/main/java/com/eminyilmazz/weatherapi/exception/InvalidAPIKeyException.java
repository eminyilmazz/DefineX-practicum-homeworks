package com.eminyilmazz.weatherapi.exception;

public class InvalidAPIKeyException extends IllegalArgumentException {
    private static final String GENERIC_MESSAGE = "Error with API Key!";

    public InvalidAPIKeyException(String s) {
        super(GENERIC_MESSAGE + " " + s);
    }
}
