package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.DataAlreadyExistsException;
import com.bank.exception.DataNotFoundException;
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
//		return lcrRepository.save(lcr);
		
		int count = lcrRepository.countByPeriod(lcr.getPeriod());  
	      
	    if (count > 0) {  
	        throw new DataAlreadyExistsException("Data for period " + lcr.getPeriod() + " already exists. You can only modify it.");  
	    }  
	      
	    return lcrRepository.save(lcr);  
	}

	@Override
	public Lcr getLcrByPeriod() {
		return lcrRepository.getLcrByPeriod();
	}

	@Override
	public void deleteLcr(int id) {
		if (!lcrRepository.existsById(id)) {
            throw new DataNotFoundException("LCR with ID " + id + " not found.");
        }
		lcrRepository.deleteById(id);
	}

	@Override
	public List<Lcr> allLcr(int n) {
		return lcrRepository.getLcrByMonthPeriod(n);
	}

	@Override
	public Lcr editLcr(int id, Lcr updatedLcr) {
		if (!lcrRepository.existsById(id)) {
            throw new DataNotFoundException("Llcr with ID " + id + " not found.");
        }

		updatedLcr.setId(id); // Ensure the ID remains the same
       return lcrRepository.save(updatedLcr);
	}
	
}
