package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.modal.Lcr;
import com.bank.modal.Roa;

@Service
public interface lcrService {
	public Lcr addLcr(Lcr lcr);
	public double calculateLcr(Lcr lcr);
	public Lcr getLcrByPeriod();
	public void deleteLcr(int id);
	public List<Lcr> allLcr(int n);
	public Lcr editLcr(int id, Lcr updatedLcr);
}
