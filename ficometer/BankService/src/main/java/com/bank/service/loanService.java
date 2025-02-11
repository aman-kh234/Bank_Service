package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.modal.Loan;

@Service
public interface loanService {
	public String addLoan(Loan loan);
	public Loan updateLoan(Loan loan) throws Exception;
	public void deleteLoan(int id) throws Exception;
}
