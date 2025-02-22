package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.DataAlreadyExistsException;
import com.bank.exception.DataNotFoundException;
import com.bank.modal.Lcr;
import com.bank.modal.Nsfr;
import com.bank.repository.NsfrRepo;
import com.bank.repository.lcrRepo;
import com.bank.service.NsfrService;
import com.bank.service.lcrService;

@Service
public class NsfrServiceImpl implements NsfrService{
	@Autowired
	private NsfrRepo NsfrRepository;
	
	@Override
	public double calculateNsfr(Nsfr nsfr) {
		double ASF = nsfr.getAvailableStableFund();
		double RSF = nsfr.getRequiredStableFund();
		
		double NSFR = (ASF/RSF)*100;
		return NSFR;
	}

	@Override
	public Nsfr addNsfr(Nsfr nsfr) {
//		return NsfrRepository.save(nsfr);
		
		int count = NsfrRepository.countByPeriod(nsfr.getPeriod());  
	      
	    if (count > 0) {  
	        throw new DataAlreadyExistsException("Data for period " + nsfr.getPeriod() + " already exists. You can only modify it.");  
	    }  
	      
	    return NsfrRepository.save(nsfr); 
	}

	@Override
	public Nsfr getNsfrByPeriod() {
		return NsfrRepository.getNsfrByPeriod();
	}

	@Override
	public void deleteNsfr(int id) {
		if (!NsfrRepository.existsById(id)) {
            throw new DataNotFoundException("NSFR with ID " + id + " not found.");
        }
		NsfrRepository.deleteById(id);
	}

	@Override
	public List<Nsfr> allNsfr(int n) {
		return NsfrRepository.getNsfrByMonthPeriod(n);
	}

	@Override
	public Nsfr editNsfr(int id, Nsfr updatedNsfr) {
		// TODO Auto-generated method stub
		 if (!NsfrRepository.existsById(id)) {
	            throw new DataNotFoundException("Nsfr with ID " + id + " not found.");
	        }

		 updatedNsfr.setId(id); // Ensure the ID remains the same
	       return NsfrRepository.save(updatedNsfr);
		
	}
	
}
