package com.eminyilmazz.weatherapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherResponse {
    @JsonProperty("location")
    private WeatherLocation location;
    @JsonProperty("current")
    private WeatherCurrent current;

}
