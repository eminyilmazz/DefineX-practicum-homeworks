package com.eminyilmazz.orderhw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.eminyilmazz")
@EntityScan(basePackages = "com.eminyilmazz.orderhw.entity")
@EnableJpaRepositories(basePackages = "com.eminyilmazz.orderhw.repository")
public class OrderHwApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderHwApplication.class, args);
    }

}
