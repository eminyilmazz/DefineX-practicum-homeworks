package com.eminyilmazz.weatherapi.controller;

import com.eminyilmazz.weatherapi.service.IWeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/weather/api")
public class WeatherController {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    IWeatherService weatherService;

    @GetMapping(value = "/get")
    public void getWeather(@RequestParam String city) {
        weatherService.getWeather(city);
    }

    @GetMapping("/test")
    void testter(){
    }
}
