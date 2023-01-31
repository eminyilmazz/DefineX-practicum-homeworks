package com.eminyilmazz.weatherapi.service.implementation;

import com.eminyilmazz.weatherapi.entity.ErrorResponse;
import com.eminyilmazz.weatherapi.entity.WeatherResponse;
import com.eminyilmazz.weatherapi.exception.CityNotFound;
import com.eminyilmazz.weatherapi.exception.InvalidAPIKeyException;
import com.eminyilmazz.weatherapi.service.IWeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

import static com.eminyilmazz.weatherapi.utility.mapper.RequestMapper.getCurrentUriString;

@Service
public class WeatherService implements IWeatherService {
    @Value("${weather.api.key}")
    private String key;
    @Value("${weather.api.request.url:https://api.weatherapi.com/v1}")
    private String url;
    @Autowired
    RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public WeatherResponse getCurrent(String city) throws JsonProcessingException {
        String uri = getCurrentUriString(city, key, 0, url, "current");
        HttpHeaders headers = new HttpHeaders();
        headers.add("METHOD_NAME", "getCurrent");
        return sendWeatherRequest(uri, headers);
    }

    private WeatherResponse sendWeatherRequest(String uri, HttpHeaders headers) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        try {
            WeatherResponse rsp = objectMapper.readValue(response.getBody(), WeatherResponse.class);
            return rsp;
        } catch (JsonProcessingException e) {
            logger.error("Error occurred while parsing response to WeatherResponse");
            throw e;
        }
    }

    @Override
    public WeatherResponse getForecast(String city, Integer days) throws JsonProcessingException {
        String uri = getCurrentUriString(city, key, days, url, "forecast");
        HttpHeaders headers = new HttpHeaders();
        headers.add("METHOD_NAME", "getForecast");
        return sendWeatherRequest(uri, headers);
    }

    @Override
    public void checkResponse(ResponseEntity<?> response) throws JsonProcessingException {
        if(response.getStatusCode().value() == 200) return;
        ErrorResponse error = objectMapper.readValue(response.getBody().toString(), ErrorResponse.class);
        if(Stream.of(1002, 2006, 2007, 2008, 2009).anyMatch(i -> i == response.getStatusCode().value())) {
            logger.error(error.getError().getMessage() + "API Key: " + key);
            throw new InvalidAPIKeyException(error.getError().getMessage() + "API Key: " + key);
        } else if (error.getError().getCode() == 1006) {
            logger.error(error.getError().getMessage());
            throw new CityNotFound(error.getError().getMessage());
        }
    }
}
