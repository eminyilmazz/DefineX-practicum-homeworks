package com.eminyilmazz.weatherapi.exception;

public class CityNotFound extends IllegalArgumentException {
    private static final String GENERIC_MESSAGE = "Error with provided city!";

    public CityNotFound(String s) {
        super(s);
    }
}
