package com.eminyilmazz.orderhw.service.implementation;

import com.eminyilmazz.orderhw.entity.Bill;
import com.eminyilmazz.orderhw.entity.Customer;
import com.eminyilmazz.orderhw.entity.dto.BillDto;
import com.eminyilmazz.orderhw.repository.BillRepository;
import com.eminyilmazz.orderhw.service.IBillService;
import com.eminyilmazz.orderhw.service.ICustomerService;
import com.eminyilmazz.orderhw.util.mapper.BillMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.eminyilmazz.orderhw.util.UtilityService.formatCurrency;

@Service
public class BillService implements IBillService {
    private static final Logger logger = LoggerFactory.getLogger(BillService.class);
    @Autowired
    BillRepository billRepository;
    @Autowired
    ICustomerService customerService;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<BillDto> getAll() {
        List<BillDto> billList = billRepository.findAll().stream().map(BillMapper::toDto).collect(Collectors.toList());
        try {
            logger.info("All bills: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(billList));
        } catch (JsonProcessingException e) {
            logger.error("Error trying to write the output in BillService.getAll()");
        }
        return billList;
    }

    @Override
    public List<BillDto> getBillsOfCustomerCreatedInJune() {
        List<Customer> customerList = customerService.getAllCustomersCreatedInJune();
        List<BillDto> billList = customerList.stream()
                .flatMap(c -> billRepository.findBillsByCustomer(c).stream())
                .map(BillMapper::toDto)
                .collect(Collectors.toList());
        try {
            logger.info("Bill information of customers created in June: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(billList));
        } catch (JsonProcessingException e) {
            logger.error("Error trying to write the output in BillService.getBillsOfCustomerCreatedInJune()");
        }
        return billList;
    }

    @Override
    public String getTotalCountOfBillsByCustomerCreatedInJune() {
        List<Customer> customerList = customerService.getAllCustomersCreatedInJune();
        long total = customerList.stream()
                .flatMapToLong(c -> billRepository.findBillsByCustomer(c).stream().mapToLong(Bill::getCost))
                .sum();
        logger.info("Total value of bills of customers created in June: {}", total);
        return formatCurrency(total);
    }

    @Override
    public List<BillDto> getAllBillsAbove(Long amount) {
        List<BillDto> billList = billRepository.findBillsByCostGreaterThanEqual(amount).stream().map(BillMapper::toDto).collect(Collectors.toList());
        try {
            logger.info("All bills where the cost is above {}: {}", amount, objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(billList));
        } catch (JsonProcessingException e) {
            logger.error("Error trying to write the output in BillService.getAllBillsAbove({})", amount);
        }
        return billList;
    }

    @Override
    public String getAverageAbove(Long amount) {
        List<Bill> billList = billRepository.findBillsByCostGreaterThanEqual(amount);
        double average = billList.stream()
                .mapToLong(Bill::getCost)
                .average()
                .orElse(0.0);
        logger.info("Average value of bills: {}", average);
        return formatCurrency(Long.valueOf(String.valueOf(average)));
    }
}
