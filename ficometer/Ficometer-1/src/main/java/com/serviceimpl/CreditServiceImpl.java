package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CreditAccount;
import com.repo.CreditAccountRepo;
import com.service.CreditService;

@Service
public class CreditServiceImpl implements CreditService{
	@Autowired
	private CreditAccountRepo creditRepository;
	public CreditAccount addCredit(CreditAccount credit) {
		System.out.println("-----------------------------------");
		System.out.println(credit.toString());
		System.out.println("-----------------------------------");
		return creditRepository.saveAndFlush(credit);
	}
}
