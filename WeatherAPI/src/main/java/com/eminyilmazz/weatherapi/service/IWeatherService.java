package com.eminyilmazz.weatherapi.service;

import com.eminyilmazz.weatherapi.entity.WeatherResponse;

public interface IWeatherService {
    WeatherResponse getCurrent(String city);

    WeatherResponse getForecast(String city, Integer days);
}
