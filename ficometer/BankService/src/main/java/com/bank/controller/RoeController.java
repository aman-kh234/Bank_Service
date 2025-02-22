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
import com.bank.service.RoeService;

@RestController
@RequestMapping("/roe")
public class RoeController {
	@Autowired
	private RoeService RoeServiceImpl;
	
	@PostMapping("/add")
	public Roe addRoe(@RequestBody Roe roe) {
		return RoeServiceImpl.addRoe(roe);
	}
	
	@PutMapping("/edit/{id}")
    public ResponseEntity<Roe> editRoe(@PathVariable int id, @RequestBody Roe updatedRoe) {
        Roe updated = RoeServiceImpl.editRoe(id, updatedRoe);
        return ResponseEntity.ok(updated);
    }
	
	@GetMapping("/get/RoeByPeriod")
	public Roe getByPeriod() {
		return RoeServiceImpl.getRoeByPeriod();
	}
	
	@GetMapping("/calculate/latest")
	public double calculateRoeLatest(){
		return RoeServiceImpl.calculateRoe(getByPeriod());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteNsfr(@PathVariable int id) {
		RoeServiceImpl.deleteRoe(id);
	}
	
	 @GetMapping("/calculate/months/{n}")
	    public List<Roe> calculateAllRoe(@PathVariable int n) {
	        return RoeServiceImpl.allRoe(n);
	    }
}
