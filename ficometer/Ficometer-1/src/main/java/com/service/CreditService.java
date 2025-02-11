package com.service;

import org.springframework.stereotype.Service;

import com.model.CreditAccount;

@Service
public interface CreditService {
	public CreditAccount addCredit(CreditAccount credit);
}
