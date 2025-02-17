package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.modal.Roe;

@Service
public interface RoeService {
	public Roe addRoe(Roe roe);
	public double calculateRoe(Roe roe);
	public Roe getRoeByPeriod();
	public void deleteRoe(int id);
	public List<Roe> allRoe(int n);
}
