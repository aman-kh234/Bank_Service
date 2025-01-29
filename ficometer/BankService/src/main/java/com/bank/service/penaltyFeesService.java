package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.modal.PenaltyFees;

@Service
public interface penaltyFeesService {
	public String addPenalty(PenaltyFees penalty);
	public PenaltyFees updatePenalty(PenaltyFees penalty) throws Exception;
	public void deletePenalty(int id) throws Exception;
}
