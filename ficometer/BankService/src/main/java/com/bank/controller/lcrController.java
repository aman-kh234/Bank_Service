package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.modal.Lcr;
import com.bank.service.lcrService;

@RestController
@RequestMapping("/")
public class lcrController {
	@Autowired
	private lcrService lcrServiceImpl;
	
	@PostMapping("/add/lcr")
	public Lcr addLcr(@RequestBody Lcr lcr) {
		return lcrServiceImpl.addLcr(lcr);
	}
	
	@GetMapping("/get/lcrByPeriod")
	public Lcr getByPeriod() {
		return lcrServiceImpl.getLcrByPeriod();
	}
	
	@GetMapping("/calculate/lcr/latest")
	public double calculateLcrLatest(){
		return lcrServiceImpl.calculateLcr(getByPeriod());
	}
	
	@DeleteMapping("/delete/lcr/{id}")
	public void deleteLcr(@PathVariable int id) {
		lcrServiceImpl.deleteLcr(id);
	}
}
