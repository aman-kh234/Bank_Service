package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.modal.Npa;

@Service
public interface NpaService {
	public Npa addNpa(Npa npa);
    public double calculateNpa(Npa npa);
    public Npa getNpaByPeriod();
    public void deleteNpa(int id);
}
