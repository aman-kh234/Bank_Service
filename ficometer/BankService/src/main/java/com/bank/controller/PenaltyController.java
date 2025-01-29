package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.modal.PenaltyFees;
import com.bank.service.penaltyFeesService;

@RestController
@RequestMapping("/")
public class PenaltyController {
	@Autowired
	private penaltyFeesService penaltyService;
	
	@PostMapping("/add/penalty")
	private String addPenalty(@RequestBody PenaltyFees penaltyFees) {
		return penaltyService.addPenalty(penaltyFees);
	}
	
	@PutMapping("/update/penalty")
	private PenaltyFees updatePenalty(@RequestBody PenaltyFees penaltyFees) throws Exception {
		return penaltyService.updatePenalty(penaltyFees);
	}
	
	@DeleteMapping("/delete/penalty/{id}")
	private void deletePenalty(@PathVariable int id) throws Exception {
		penaltyService.deletePenalty(id);
	}
}
