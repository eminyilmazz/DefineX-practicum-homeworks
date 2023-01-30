package com.eminyilmazz.weatherapi.controller;

import com.eminyilmazz.weatherapi.entity.ForecastRequest;
import com.eminyilmazz.weatherapi.entity.WeatherResponse;
import com.eminyilmazz.weatherapi.service.IWeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/weather/api")
public class WeatherController {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    IWeatherService weatherService;

    @GetMapping(value = "/current")
    public void getCurrent(@RequestParam String city) {
        weatherService.getCurrent(city);
    }

    @GetMapping(value = "/forecast")
    public ResponseEntity<WeatherResponse> getForecast(@RequestBody @Valid ForecastRequest request) {
        return ResponseEntity.ok(weatherService.getForecast(request.getCity(), request.getDays()));
    }
}
