package com.eminyilmazz.weatherapi.interceptor;

import com.eminyilmazz.weatherapi.annotations.WeatherRequestIntercept;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RestTemplateInterceptor.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        //AopUtils.getTargetClass(execution.getClass()).isAnnotationPresent(WeatherRequestIntercept.class)
        String methodName = "Unknown";
        List<NameValuePair> queryParams = URLEncodedUtils.parse(request.getURI(), StandardCharsets.UTF_8);
        List<String> methodHeader = request.getHeaders().remove("METHOD_NAME");
        if(!CollectionUtils.isEmpty(methodHeader)) methodName = methodHeader.get(0);
        if(methodName.equalsIgnoreCase("getWeather")) {
            try {
                String city = queryParams.stream().filter(i -> i.getName().equalsIgnoreCase("q")).findAny().orElseThrow(IllegalArgumentException::new).getValue();
                logger.info("Getting weather info for city: {}", city);
                ClientHttpResponse response = execution.execute(request, body);
                logger.info("Received response with status code: {} and headers: {}", response.getStatusCode(), response.getHeaders());
                return response;
            } catch (Exception e) {
                logger.error("Failed to deserialize request body to WeatherRequest, request body: {}\n Error: {}", StreamUtils.copyToString(new ByteArrayInputStream(body), Charset.defaultCharset()), e.getMessage());
            }
        }
         return execution.execute(request, body);

    }
}
