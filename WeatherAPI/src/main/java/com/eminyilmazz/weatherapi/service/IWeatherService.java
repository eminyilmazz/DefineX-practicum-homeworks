package com.eminyilmazz.weatherapi.service;

import com.eminyilmazz.weatherapi.entity.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface IWeatherService {
    WeatherResponse getCurrent(String city) throws JsonProcessingException;

    WeatherResponse getForecast(String city, Integer days) throws JsonProcessingException;

    void checkResponse(ResponseEntity<?> response) throws JsonProcessingException;
}
