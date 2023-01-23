package com.eminyilmazz.orderhw.controller;

import com.eminyilmazz.orderhw.entity.dto.BillDto;
import com.eminyilmazz.orderhw.service.IBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
        Long longAmount = Long.parseLong(String.valueOf(amount.orElseGet(() -> 1500.0) * 100));
        return ResponseEntity.ok(billService.getAllBillsAbove(longAmount));
    }

    @GetMapping(value = "/averageAbove")
    public ResponseEntity<String> getAverageAbove(@RequestParam(required = false) Optional<Double> amount) {
        Long longAmount = Long.parseLong(String.valueOf(amount.orElseGet(() -> 1500.0) * 100));
        return ResponseEntity.ok(billService.getAverageAbove(longAmount));
    }
}
