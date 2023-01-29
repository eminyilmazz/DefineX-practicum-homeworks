package com.eminyilmazz.weatherapi.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Configuration
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RestTemplateInterceptor.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String methodName = "Unknown";
        List<NameValuePair> queryParams = URLEncodedUtils.parse(request.getURI(), StandardCharsets.UTF_8);
        List<String> methodHeader = request.getHeaders().remove("METHOD_NAME");
        if(!CollectionUtils.isEmpty(methodHeader)) methodName = methodHeader.get(0);
        if(methodName.equalsIgnoreCase("getForecast") || methodName.equalsIgnoreCase("getCurrent")) {
            try {
                String city = queryParams.stream().filter(i -> i.getName().equalsIgnoreCase("q")).findAny().orElseThrow(IllegalArgumentException::new).getValue();
                Optional<NameValuePair> days = queryParams.stream().filter(i -> i.getName().equalsIgnoreCase("days")).findAny();
                days.ifPresent(nameValuePair -> logger.info("Getting weather info for {} days.", nameValuePair.getValue()));
                logger.info("Getting weather info for city: {}", city);
                ClientHttpResponse response = execution.execute(request, body);
                logger.info("Received response with status code: {} and headers: {}", response.getStatusCode(), response.getHeaders());
                return response;
            } catch (Exception e) {
                logger.error("Failed to send request. Request body: {}\nRequest URI: {}\nError: {}", StreamUtils.copyToString(new ByteArrayInputStream(body), Charset.defaultCharset()), request.getURI(), e.getMessage());
                throw e;
            }
        }
         return execution.execute(request, body);
    }
}
