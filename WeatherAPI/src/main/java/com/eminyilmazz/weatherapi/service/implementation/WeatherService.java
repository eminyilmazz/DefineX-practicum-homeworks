package com.eminyilmazz.weatherapi.service.implementation;

import com.eminyilmazz.weatherapi.entity.WeatherResponse;
import com.eminyilmazz.weatherapi.service.IWeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.eminyilmazz.weatherapi.utility.mapper.RequestMapper.getCurrentUriString;

@Service
public class WeatherService implements IWeatherService {
    @Value("${weather.api.key}")
    private String key;
    @Value("${weather.api.request.url:https://api.weatherapi.com/v1}")
    private String url;
    @Autowired
    RestTemplate restTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public WeatherResponse getCurrent(String city) {
        String uri = getCurrentUriString(city, key, 0, url, "current");
        HttpHeaders headers = new HttpHeaders();
        headers.add("METHOD_NAME", "getCurrent");
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        try {
            WeatherResponse rsp = objectMapper.readValue(response.getBody(), WeatherResponse.class);
            return rsp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WeatherResponse getForecast(String city, Integer days) {
        String uri = getCurrentUriString(city, key, days, url, "forecast");
        HttpHeaders headers = new HttpHeaders();
        headers.add("METHOD_NAME", "getForecast");
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        try {
            WeatherResponse rsp = objectMapper.readValue(response.getBody(), WeatherResponse.class);
            return rsp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
