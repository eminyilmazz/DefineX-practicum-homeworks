package com.eminyilmazz.orderhw.service.implementation;

import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.BillDto;
import com.eminyilmazz.orderhw.repository.BillRepository;
import com.eminyilmazz.orderhw.service.IBillService;
import com.eminyilmazz.orderhw.service.ICustomerService;
import com.eminyilmazz.orderhw.util.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService implements IBillService {
    @Autowired
    BillRepository billRepository;
    @Autowired
    ICustomerService customerService;

    @Override
    public List<BillDto> getBillsOfCustomerCreatedInJune() {
        List<Customer> customerList = customerService.getAllCustomersCreatedInJune();
        return customerList.stream()
                .flatMap(c -> billRepository.getBillsByCustomer(c).stream())
                .map(BillMapper::toDto)
                .collect(Collectors.toList());
    }
}
