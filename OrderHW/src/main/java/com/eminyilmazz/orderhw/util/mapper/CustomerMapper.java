package com.eminyilmazz.orderhw.util.mapper;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.CustomerDto;

import java.time.format.DateTimeFormatter;

public class CustomerMapper {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .createdDate(customer.getCreatedDate().format(DATE_TIME_FORMATTER))
                .fullName(customer.getFullName())
                .build();
    }
}
