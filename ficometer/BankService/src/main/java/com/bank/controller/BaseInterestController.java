package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.modal.BaseInterest;
import com.bank.modal.CustomerDto;
import com.bank.modal.PenaltyFees;
import com.bank.service.CustomerService;
import com.bank.service.baseInterest;
import com.bank.service.penaltyFeesService;

@RestController
@RequestMapping("/")
public class BaseInterestController {
	@Autowired
	private baseInterest interestService;
	@Autowired
	private CustomerService cs;
	
	@PostMapping("/add/interest")
	private String addBaseInterest(@RequestBody BaseInterest baseInt) {
		return interestService.addBaseInterest(baseInt);
	}
	@GetMapping("/get/customer/{id}")
	private CustomerDto findCustomerById(@PathVariable(name = "id") int id) {
		return cs.findCustomerById(id);
	}
	
	@PostMapping("/add/customer")
	public CustomerDto addCustomer(@RequestBody CustomerDto customer) {
		return cs.add(customer);
	}
	@PutMapping("/update/interest")
	private BaseInterest updateInterest(@RequestBody BaseInterest baseInt) throws Exception {
		return interestService.updatebaseInterest(baseInt);
	}
	
	@DeleteMapping("/delete/interest/{id}")
	private void deleteInterest(@PathVariable int id) throws Exception {
		interestService.deleteBaseInterest(id);
	}
}
