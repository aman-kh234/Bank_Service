package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.modal.Nsfr;

@Service
public interface NsfrService {
	public Nsfr addNsfr(Nsfr nsfr);
	public double calculateNsfr(Nsfr nsfr);
	public Nsfr getNsfrByPeriod();
	public void deleteNsfr(int id);
	public List<Nsfr> allNsfr(int n);
}
