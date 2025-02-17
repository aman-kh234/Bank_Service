package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.modal.BaseInterest;
import com.bank.modal.Loan;
import com.bank.modal.PenaltyFees;

@Service
public interface FeeCalculationService {
	public double fee_calculated(Loan loan);
}
