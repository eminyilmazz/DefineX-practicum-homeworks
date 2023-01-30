package com.eminyilmazz.weatherapi.entity;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class ForecastRequest {
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message = "Enter a proper city name")
    @NotBlank(message = "City cannot be blank!")
    String city;
    @Min(value = 1, message = "Days count must be more than or equal to 1.")
    @Max(value = 14, message = "Days count must be less than or equal to 14.")
    @NotNull(message = "Days count cannot be null for forecast request.")
    Integer days;
}
