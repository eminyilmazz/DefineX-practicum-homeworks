package com.eminyilmazz.orderhw.util.mapper;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.CustomerDto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerMapper {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private CustomerMapper(){}

    public static CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(String.valueOf(customer.getId()))
                .createdDate(customer.getCreatedDate().format(DATE_TIME_FORMATTER))
                .fullName(customer.getFullName())
                .build();
    }

    public static Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .createdDate(LocalDateTime.now())
                .fullName(customerDto.getFullName())
                .build();
    }
}
