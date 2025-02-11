package com.bank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.modal.Roa;
import com.bank.repository.RoaRepo;
import com.bank.service.RoaService;

@Service
public class RoaServiceImpl implements RoaService{
	@Autowired
	private RoaRepo roaRepository;
	@Override
	public Roa addRoa(Roa roa) {
		return roaRepository.save(roa);
	}

	@Override
	public double calculateRoa(Roa roa) {
		double totalAssetStart = roa.getTotalAssetStart();
		double totalAssetEnd = roa.getTotalAssetEnd();
		double netIncome = roa.getNetIncome();
		double avg = (totalAssetStart+totalAssetEnd)/2.0;
		double ans =  (netIncome/avg)*100;
		return ans;
	}

	@Override
	public Roa getRoaByPeriod() {
		return roaRepository.getRoaByPeriod();
	}

	@Override
	public void deleteRoa(int id) {
		roaRepository.deleteById(id);
	}
	
}
