package com.eminyilmazz.orderhw.service.implementation;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.CustomerDto;
import com.eminyilmazz.orderhw.repository.CustomerRepository;
import com.eminyilmazz.orderhw.service.ICustomerService;
import com.eminyilmazz.orderhw.util.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.eminyilmazz.orderhw.util.mapper.CustomerMapper.toEntity;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    public List<CustomerDto> getAllCustomers() {
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

    @Override
    public ResponseEntity<?> addCustomer(CustomerDto customerDto) {
        Customer customer = toEntity(customerDto);
        Optional<Customer> savedCustomer = Optional.of(customerRepository.saveAndFlush(customer));
        if (!savedCustomer.isPresent()) return ResponseEntity.badRequest().body("Failed saving customer");
        return ResponseEntity.ok(savedCustomer.get());
    }
}
