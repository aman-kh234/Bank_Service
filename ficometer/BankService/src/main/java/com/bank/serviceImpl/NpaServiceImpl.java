package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.modal.Npa;
import com.bank.repository.NpaRepo;
import com.bank.service.NpaService;

@Service
public class NpaServiceImpl implements NpaService{
	@Autowired
	private NpaRepo npaRepository;
	
	@Override
	public Npa addNpa(Npa npa) {
		return npaRepository.save(npa);
	}

	@Override
	public double calculateNpa(Npa npa) {
		double nonPerformingAsset = npa.getNonPerformingAsset();
		double totalLoans = npa.getTotalLoan();
		
		double ans = (nonPerformingAsset/totalLoans)*100;
		return ans;
	}

	@Override
	public Npa getNpaByPeriod() {
		
		return npaRepository.getNpaByPeriod();
	}

	@Override
	public void deleteNpa(int id) {
		npaRepository.deleteById(id);
	}

	@Override
	public List<Npa> allNpa(int n) {
		return npaRepository.getNpaByMonthPeriod(n);
	}
	
}
