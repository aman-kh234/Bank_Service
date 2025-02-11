package com.bank.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.modal.CustomerDto;

@FeignClient(name = "CUSTOMER-SERVICE" , url="http://localhost:8080/")
public interface CustomerService {
	@GetMapping("/{id}")
	public CustomerDto findCustomerById(@PathVariable(name = "id") int id);
	
	@PostMapping("/add")
	public CustomerDto add(@RequestBody CustomerDto customer);
}
