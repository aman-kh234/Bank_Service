package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.modal.Npa;

@Service
public interface NpaService {
	public Npa addNpa(Npa npa);
    public double calculateNpa(Npa npa);
    public Npa getNpaByPeriod();
    public void deleteNpa(int id);
    public List<Npa> allNpa(int n);
	public Npa editNpa(int id, Npa updatedNpa);
}
