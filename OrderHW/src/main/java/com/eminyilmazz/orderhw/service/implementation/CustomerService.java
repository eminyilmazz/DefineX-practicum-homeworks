package com.eminyilmazz.orderhw.service.implementation;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.CustomerDto;
import com.eminyilmazz.orderhw.repository.BillRepository;
import com.eminyilmazz.orderhw.repository.CustomerRepository;
import com.eminyilmazz.orderhw.service.ICustomerService;
import com.eminyilmazz.orderhw.util.mapper.CustomerMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.eminyilmazz.orderhw.util.UtilityService.formatCurrency;
import static com.eminyilmazz.orderhw.util.mapper.CustomerMapper.toEntity;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BillRepository billRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    ObjectMapper objectMapper;

    public List<CustomerDto> getAllCustomers() {
        logger.trace("Getting all customers");
        List<CustomerDto> customerList = customerRepository.findAll().stream().map(CustomerMapper::toDto).collect(Collectors.toList());
        try {
            logger.info("All customers: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerList));
        } catch (JsonProcessingException e) {
            logger.error("Error trying to write the output in CustomerService.getAllCustomersNameContainingC()");
        }
        return customerList;
    }

    @Override
    public List<Customer> getAllCustomersCreatedInJune() {
        logger.trace("Getting customers created in June");
        return customerRepository.getCustomersCreatedInJune();
    }

    @Override
    public List<CustomerDto> getAllCustomersNameContainingC() {
        logger.trace("Getting customers that contains 'c'/'C' in their name");
        List<CustomerDto> customerList = customerRepository.findAll().stream()
                .filter(i -> i.getFullName().toLowerCase().contains("c"))
                .map(CustomerMapper::toDto).collect(Collectors.toList());
        try {
            logger.info("Customers containing 'C' in their name: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerList));
        } catch (JsonProcessingException e) {
            logger.error("Error trying to write the output in CustomerService.getAllCustomersNameContainingC()");
        }
        return customerList;
    }

    @Override
    public ResponseEntity<?> addCustomer(CustomerDto customerDto) {
        Customer customer = toEntity(customerDto);
        Optional<Customer> savedCustomer = Optional.of(customerRepository.saveAndFlush(customer));
        if (!savedCustomer.isPresent()) return ResponseEntity.badRequest().body("Failed saving customer");
        return ResponseEntity.ok(savedCustomer.get());
    }

    @Override
    public Set<String> getCustomerNamesWithBelow(Long amount) {
        Set<String> nameList = billRepository.findBillsByCostLessThanEqual(amount);
        try {
            logger.info("Customer names who have bills where the cost is below {}: {}", formatCurrency(amount), objectMapper.writeValueAsString(nameList));
        } catch (JsonProcessingException e) {
            logger.error("Error trying to write the output in CustomerService.getCustomerNamesWithBelow({})", amount);
        }
        return nameList;
    }
}
