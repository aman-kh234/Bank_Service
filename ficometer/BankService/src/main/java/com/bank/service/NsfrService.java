package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.modal.Nsfr;

@Service
public interface NsfrService {
	public Nsfr addNsfr(Nsfr nsfr);
	public double calculateNsfr(Nsfr nsfr);
	public Nsfr getNsfrByPeriod();
	public void deleteNsfr(int id);
}
