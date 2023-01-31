package com.eminyilmazz.weatherapi.exception.handler;

import com.eminyilmazz.weatherapi.exception.CityNotFound;
import com.eminyilmazz.weatherapi.exception.InvalidAPIKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class WeatherExceptionHandler {

    @ExceptionHandler({InvalidAPIKeyException.class})
    private ResponseEntity<Map<String, String>> handleAPIException(InvalidAPIKeyException e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler({CityNotFound.class})
    private ResponseEntity<Map<String, String>> handCityNotFoundException(CityNotFound e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({Exception.class})
    private ResponseEntity<Map<String, String>> handleExcetion(Exception e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
