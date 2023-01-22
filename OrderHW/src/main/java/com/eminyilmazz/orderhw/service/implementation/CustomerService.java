package com.eminyilmazz.orderhw.service.implementation;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.CustomerDto;
import com.eminyilmazz.orderhw.repository.CustomerRepository;
import com.eminyilmazz.orderhw.service.ICustomerService;
import com.eminyilmazz.orderhw.util.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    public List<CustomerDto> getAllCustomer() {
        logger.trace("Getting all customers");
        return customerRepository.findAll().stream().map(CustomerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getAllCustomersCreatedInJune() {
        logger.trace("Getting customers created in June");
        return customerRepository.findAll().stream()
                .filter(i -> i.getCreatedDate().getMonthValue() == 6)
                .map(CustomerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getAllCustomersNameContainingC() {
        logger.trace("Getting customers that contains 'c'/'C' in their name");
        return customerRepository.findAll().stream()
                .filter(i -> i.getFullName().toLowerCase().contains("c"))
                .map(CustomerMapper::toDto).collect(Collectors.toList());
    }
}
