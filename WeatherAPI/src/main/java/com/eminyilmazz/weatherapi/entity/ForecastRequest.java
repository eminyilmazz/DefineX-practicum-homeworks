package com.eminyilmazz.weatherapi.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class ForecastRequest {
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message = "Enter a proper city name")
    String city;
    @Min(value = 1, message = "Days count must be more than or equal to 1.")
    @Max(value = 14, message = "Days count must be less than or equal to 14")
    Integer days;
}
