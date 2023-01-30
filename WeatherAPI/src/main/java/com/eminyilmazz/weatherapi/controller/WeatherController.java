package com.eminyilmazz.weatherapi.controller;

import com.eminyilmazz.weatherapi.entity.CurrentRequest;
import com.eminyilmazz.weatherapi.entity.ForecastRequest;
import com.eminyilmazz.weatherapi.entity.WeatherResponse;
import com.eminyilmazz.weatherapi.service.IWeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/weather/api")
public class WeatherController {
    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    IWeatherService weatherService;

    @GetMapping(value = "/current")
    public ResponseEntity<?> getCurrent(@RequestBody @Valid CurrentRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Request has invalid variables. {} : {} - {}", bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(), bindingResult.getFieldError().getDefaultMessage());
            return ResponseEntity.badRequest().body(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(weatherService.getCurrent(request.getCity()));
    }

    @GetMapping(value = "/forecast")
    public ResponseEntity<?> getForecast(@RequestBody @Valid ForecastRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Request has invalid variables. {} : {} - {}", bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(), bindingResult.getFieldError().getDefaultMessage());
            return ResponseEntity.badRequest().body(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(weatherService.getForecast(request.getCity(), request.getDays()));
    }
}
