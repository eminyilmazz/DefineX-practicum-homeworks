package com.eminyilmazz.weatherapi.config;

import com.eminyilmazz.weatherapi.annotations.WeatherRequestIntercept;
import com.eminyilmazz.weatherapi.interceptor.RestTemplateInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @WeatherRequestIntercept
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateInterceptor());
        return restTemplate;
    }
}
