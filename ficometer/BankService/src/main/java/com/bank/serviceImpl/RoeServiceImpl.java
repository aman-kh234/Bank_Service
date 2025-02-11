package com.bank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.modal.Roe;
import com.bank.repository.RoeRepo;
import com.bank.service.RoeService;

@Service
public class RoeServiceImpl implements RoeService{
	@Autowired
	private RoeRepo roeRepository;
	
	@Override
	public Roe addRoe(Roe roe) {
		return roeRepository.save(roe);
	}

	@Override
	public double calculateRoe(Roe roe) {
		double shareEquity = roe.getShareHolderEquity();  
		double netIncome = roe.getNetIncome();
		
		double ans = (netIncome/shareEquity)*100;
		return ans;
	}

	@Override
	public Roe getRoeByPeriod() {
		return roeRepository.getRoeByPeriod();
	}

	@Override
	public void deleteRoe(int id) {
		roeRepository.deleteById(id);
	}
	
}
