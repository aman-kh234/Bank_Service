package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.modal.Roa;

@Service
public interface RoaService {
	public Roa addRoa(Roa roa);
	public double calculateRoa(Roa roa);
	public Roa getRoaByPeriod();
	public void deleteRoa(int id);
}
