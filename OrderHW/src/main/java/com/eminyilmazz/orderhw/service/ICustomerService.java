package com.eminyilmazz.orderhw.service;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAllCustomers();

    List<Customer> getAllCustomersCreatedInJune();

    List<CustomerDto> getAllCustomersNameContainingC();

    ResponseEntity<?> addCustomer(CustomerDto customerDto);
}
