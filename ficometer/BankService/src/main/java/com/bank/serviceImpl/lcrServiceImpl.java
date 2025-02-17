package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.modal.Lcr;
import com.bank.repository.lcrRepo;
import com.bank.service.lcrService;

@Service
public class lcrServiceImpl implements lcrService{
	@Autowired
	private lcrRepo lcrRepository;
	
	@Override
	public double calculateLcr(Lcr lcr) {
		double hqla = lcr.getHqla();
		double outflow = lcr.getCashOutflow();
		double inflow = lcr.getCashInflow();
		
		double ans = (hqla/(outflow-inflow))*100;
		
		return ans;
	}

	@Override
	public Lcr addLcr(Lcr lcr) {
		return lcrRepository.save(lcr);
	}

	@Override
	public Lcr getLcrByPeriod() {
		return lcrRepository.getLcrByPeriod();
	}

	@Override
	public void deleteLcr(int id) {
		lcrRepository.deleteById(id);
	}

	@Override
	public List<Lcr> allLcr(int n) {
		return lcrRepository.getLcrByMonthPeriod(n);
	}
	
}
