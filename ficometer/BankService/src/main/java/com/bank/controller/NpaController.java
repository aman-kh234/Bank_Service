package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.modal.Npa;
import com.bank.service.NpaService;

@RestController
@RequestMapping("/")
public class NpaController {
	 @Autowired
	 private NpaService npaServiceImpl;

	    @PostMapping("/add/npa")
	    public Npa addLlcr(@RequestBody Npa npa) {
	        return npaServiceImpl.addNpa(npa);
	    }

	    @GetMapping("/get/npaByPeriod")
	    public Npa getByPeriod() {
	        return npaServiceImpl.getNpaByPeriod();
	    }

	    @GetMapping("/calculate/npa/latest")
	    public double calculateNpaLatest() {
	        return npaServiceImpl.calculateNpa(getByPeriod());
	    }

	    @DeleteMapping("/delete/npa/{id}")
	    public void deleteNpa(@PathVariable int id) {
	    	npaServiceImpl.deleteNpa(id);
	    }
}
