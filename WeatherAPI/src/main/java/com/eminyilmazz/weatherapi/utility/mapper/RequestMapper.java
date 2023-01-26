package com.eminyilmazz.weatherapi.utility.mapper;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    public static String getUriString(String city, String key, String url) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("q", city);
        uriVariables.put("key", key);
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(url);
        uriVariables.forEach(uri::queryParam);
        return uri.build().toUriString();
    }
}
