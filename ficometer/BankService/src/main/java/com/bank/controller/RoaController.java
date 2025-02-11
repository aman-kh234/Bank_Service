package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.modal.Roa;
import com.bank.service.RoaService;

@RestController
@RequestMapping("/")
public class RoaController {
	@Autowired
	private RoaService RoaServiceImpl;
	
	@PostMapping("/add/roa")
	public Roa addRoa(@RequestBody Roa roa) {
		return RoaServiceImpl.addRoa(roa);
	}
	
	@GetMapping("/get/RoaByPeriod")
	public Roa getByPeriod() {
		return RoaServiceImpl.getRoaByPeriod();
	}
	
	@GetMapping("/calculate/roa/latest")
	public double calculateRoaLatest(){
		return RoaServiceImpl.calculateRoa(getByPeriod());
	}
	
	@DeleteMapping("/delete/roa/{id}")
	public void deleteNsfr(@PathVariable int id) {
		RoaServiceImpl.deleteRoa(id);
	}
}
