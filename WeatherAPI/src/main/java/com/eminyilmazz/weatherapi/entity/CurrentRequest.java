package com.eminyilmazz.weatherapi.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CurrentRequest {
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message = "Enter a proper city name")
    @NotBlank(message = "City cannot be blank!")
    String city;
}
