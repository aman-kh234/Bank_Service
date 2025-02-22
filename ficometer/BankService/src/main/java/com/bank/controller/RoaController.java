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

import com.bank.modal.Npa;
import com.bank.modal.Roa;
import com.bank.modal.Roe;
import com.bank.service.RoaService;
import com.bank.serviceImpl.RoeServiceImpl;

@RestController
@RequestMapping("/roa")
public class RoaController {
	@Autowired
	private RoaService RoaServiceImpl;
	
	@PostMapping("/add")
	public Roa addRoa(@RequestBody Roa roa) {
		return RoaServiceImpl.addRoa(roa);
	}
	
	@PutMapping("/edit/{id}")
    public ResponseEntity<Roa> editRoa(@PathVariable int id, @RequestBody Roa updatedRoa) {
        Roa updated = RoaServiceImpl.editRoa(id, updatedRoa);
        return ResponseEntity.ok(updated);
    }
	
	@GetMapping("/get/RoaByPeriod")
	public Roa getByPeriod() {
		return RoaServiceImpl.getRoaByPeriod();
	}
	
	@GetMapping("/calculate/latest")
	public double calculateRoaLatest(){
		return RoaServiceImpl.calculateRoa(getByPeriod());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteNsfr(@PathVariable int id) {
		RoaServiceImpl.deleteRoa(id);
	}
	
	 @GetMapping("/calculate/months/{n}")
	    public List<Roa> calculateAllRoa(@PathVariable int n) {
	        return RoaServiceImpl.allRoa(n);
	    }
}
