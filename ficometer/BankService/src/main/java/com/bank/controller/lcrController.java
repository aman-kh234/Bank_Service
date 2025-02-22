package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.modal.Lcr;
import com.bank.modal.Npa;
import com.bank.modal.Roa;
import com.bank.service.lcrService;

@RestController
@RequestMapping("/lcr")
public class lcrController {
	@Autowired
	private lcrService lcrServiceImpl;
	
	@PostMapping("/add")
	public Lcr addLcr(@RequestBody Lcr lcr) {
		return lcrServiceImpl.addLcr(lcr);
	}
	
	@GetMapping("/get/lcrByPeriod")
	public Lcr getByPeriod() {
		return lcrServiceImpl.getLcrByPeriod();
	}
	
	@PutMapping("/edit/{id}")
    public ResponseEntity<Lcr> editLcr(@PathVariable int id, @RequestBody Lcr updatedLcr) {
        Lcr updated = lcrServiceImpl.editLcr(id, updatedLcr);
        return ResponseEntity.ok(updated);
    }
	
	@GetMapping("/calculate/latest")
	public double calculateLcrLatest(){
		return lcrServiceImpl.calculateLcr(getByPeriod());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLcr(@PathVariable int id) {
		lcrServiceImpl.deleteLcr(id);
	}
	
	 @GetMapping("/calculate/months/{n}")
	    public List<Lcr> calculateAllLcr(@PathVariable int n) {
	        return lcrServiceImpl.allLcr(n);
	    }
}
