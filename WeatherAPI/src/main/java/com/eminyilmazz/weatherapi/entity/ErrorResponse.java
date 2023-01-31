package com.eminyilmazz.weatherapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ErrorResponse {
    @JsonProperty("error")
    Error error;
    @Getter
    @Setter
    public class Error {
        @JsonProperty("code")
        Integer code;
        @JsonProperty("message")
        String message;
    }
}
