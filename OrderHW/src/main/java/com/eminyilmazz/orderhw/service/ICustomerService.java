package com.eminyilmazz.orderhw.service;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.CustomerDto;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAllCustomer();

    List<CustomerDto> getAllCustomersCreatedInJune();

    List<CustomerDto> getAllCustomersNameContainingC();
}
