package com.eminyilmazz.orderhw.controller;

import com.eminyilmazz.orderhw.entity.dto.BillDto;
import com.eminyilmazz.orderhw.entity.dto.OrderDto;
import com.eminyilmazz.orderhw.enums.Industry;
import com.eminyilmazz.orderhw.service.IBillService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/bill/api")
public class BillController {
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);
    @Autowired
    IBillService billService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<BillDto>> getAll() {
        return ResponseEntity.ok(billService.getAll());
    }

    @GetMapping(value = "/getJune")
    public ResponseEntity<List<BillDto>> getBillsOfCustomerCreatedInJune() {
        logger.debug("/bill/api/getJune request received");
        return ResponseEntity.ok(billService.getBillsOfCustomerCreatedInJune());
    }

    @GetMapping(value = "/getJuneCost")
    public ResponseEntity<String> getTotalCountOfBillsByCustomerCreatedInJune() {
        logger.debug("/bill/api/getJune request received");
        return ResponseEntity.ok(billService.getTotalCountOfBillsByCustomerCreatedInJune());
    }

    @GetMapping(value = "/above")
    public ResponseEntity<List<BillDto>> getAllBillsAbove(@RequestParam(required = false) Optional<Double> amount) {
        logger.debug("/bill/api/above request received");
        Long longAmount = (long) (amount.orElse(1500.0) * 100);
        return ResponseEntity.ok(billService.getAllBillsAbove(longAmount));
    }

    @GetMapping(value = "/averageAbove")
    public ResponseEntity<String> getAverageAbove(@RequestParam(required = false) Optional<Double> amount) {
        logger.debug("/bill/api/getAverageAbove request received");
        Long longAmount = (long) (amount.orElse(1500.0) * 100);
        return ResponseEntity.ok(billService.getAverageAbove(longAmount));
    }

    @GetMapping(value = "/getIndustriesBelow")
    public ResponseEntity<Set<Industry>> getIndustriesBelow(@RequestParam(required = false) Optional<Double> amount) {
        logger.debug("/bill/api/getIndustriesBelow request received");
        Long longAmount = (long) (amount.orElse(750.0) * 100);
        return ResponseEntity.ok(billService.getIndustriesBelow(longAmount));
    }

    @PostMapping(value = "/order")
    public ResponseEntity<?> order(@RequestBody OrderDto order) {
        logger.debug("/bill/api/order request received");
        try {
            return ResponseEntity.ok(billService.order(order));
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
