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
import com.bank.modal.Nsfr;
import com.bank.modal.Roa;
import com.bank.service.NsfrService;
import com.bank.service.lcrService;

@RestController
@RequestMapping("/nsfr")
public class NsfrController {
	@Autowired
	private NsfrService NsfrServiceImpl;
	
	@PostMapping("/add")
	public Nsfr addnsfr(@RequestBody Nsfr nsfr) {
		return NsfrServiceImpl.addNsfr(nsfr);
	}
	
	@GetMapping("/get/NsfrByPeriod")
	public Nsfr getByPeriod() {
		return NsfrServiceImpl.getNsfrByPeriod();
	}
	
	@PutMapping("/edit/{id}")
    public ResponseEntity<Nsfr> editNsfr(@PathVariable int id, @RequestBody Nsfr updatedNsfr) {
        Nsfr updated = NsfrServiceImpl.editNsfr(id, updatedNsfr);
        return ResponseEntity.ok(updated);
    }
	
	@GetMapping("/calculate/latest")
	public double calculateNsfrLatest(){
		return NsfrServiceImpl.calculateNsfr(getByPeriod());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteNsfr(@PathVariable int id) {
		NsfrServiceImpl.deleteNsfr(id);
	}
	
	 @GetMapping("/calculate/months/{n}")
	    public List<Nsfr> calculateAllNsfr(@PathVariable int n) {
	        return NsfrServiceImpl.allNsfr(n);
	    }
}
