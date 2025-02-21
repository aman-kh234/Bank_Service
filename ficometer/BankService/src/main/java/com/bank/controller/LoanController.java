package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.modal.Loan;
import com.bank.service.loanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
	@Autowired
	private loanService loanS;
	
	@PostMapping("/add")
	private String addLoan(@RequestBody Loan loan) {
		return loanS.addLoan(loan);
	}
	
	@PutMapping("/update")
	private Loan updateLoan(@RequestBody Loan loan) throws Exception {
		return loanS.updateLoan(loan);
	}
	
	@DeleteMapping("/delete/{id}")
	private void deleteLoan(@PathVariable int id) throws Exception {
		loanS.deleteLoan(id);
	}
}
