package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.modal.BaseInterest;
import com.bank.modal.Loan;
import com.bank.service.FeeCalculationService;

@RestController
@RequestMapping("/")
public class FeeCalculationController {
	@Autowired
	private FeeCalculationService feeCalculationService;
	
	@PostMapping("/calculate")
    public double calculateLoanInterest(@RequestBody Loan request) {
        return feeCalculationService.fee_calculated(request);
    }
}
