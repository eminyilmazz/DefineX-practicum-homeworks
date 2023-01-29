package com.eminyilmazz.weatherapi.utility.mapper;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    public static String getCurrentUriString(String city, String key, Integer days, String url, String action) {
        String actionPath = "";
        if (action.equalsIgnoreCase("current")) actionPath = "current.json";
        else actionPath = "forecast.json";
        Map<String, String> uriVariables = getUriVariables(city, key, days);
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(url);
        uri.pathSegment(actionPath);
        uriVariables.forEach(uri::queryParam);
        return uri.build().toUriString();
    }

    public static Map<String, String> getUriVariables(String city, String key, Integer days) {
        Map<String, String> variableMap = new HashMap<>();
        if (days > 0) variableMap.put("days", String.valueOf(days));
        variableMap.put("q", city);
        variableMap.put("key", key);
        return variableMap;
    }
}
