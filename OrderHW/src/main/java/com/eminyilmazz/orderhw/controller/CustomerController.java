package com.eminyilmazz.orderhw.controller;

import com.eminyilmazz.orderhw.entity.dto.CustomerDto;
import com.eminyilmazz.orderhw.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    ICustomerService customerService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        logger.debug("/customer/api/all request received");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getAllCustomers());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto) {
        logger.debug("/customer/api/add request received");
        return customerService.addCustomer(customerDto);
    }

    @GetMapping("/getC")
    public ResponseEntity<List<CustomerDto>> getCustomersContainingC() {
        logger.debug("/customer/api/getC request received");
        return ResponseEntity.ok(customerService.getAllCustomersNameContainingC());
    }
}
