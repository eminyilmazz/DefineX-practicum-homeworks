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
public class WeatherCurrent {
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("temp_c")
    private double temperature;
    @JsonProperty("condition")
    private WeatherCondition condition;
    @JsonProperty("wind_kph")
    private double windSpeed;
    @JsonProperty("wind_dir")
    private String windDirection;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("cloud")
    private int cloud;
    @JsonProperty("feelslike_c")
    private double temperatureFeelsLike;
}
