package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.DataAlreadyExistsException;
import com.bank.exception.DataNotFoundException;
import com.bank.modal.Npa;
import com.bank.repository.NpaRepo;
import com.bank.service.NpaService;

@Service
public class NpaServiceImpl implements NpaService{
	@Autowired
	private NpaRepo npaRepository;
	
	@Override
	public Npa addNpa(Npa npa) {
//		return npaRepository.save(npa);
		
		int count = npaRepository.countByPeriod(npa.getPeriod());  
	      
	    if (count > 0) {  
	        throw new DataAlreadyExistsException("Data for period " + npa.getPeriod() + " already exists. You can only modify it.");  
	    }  
	      
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
		 if (!npaRepository.existsById(id)) {
	            throw new DataNotFoundException("Npa with ID " + id + " not found.");
	        }
		npaRepository.deleteById(id);
	}

	@Override
	public List<Npa> allNpa(int n) {
		return npaRepository.getNpaByMonthPeriod(n);
	}

	@Override
	public Npa editNpa(int id, Npa updatedNpa) {
		if (!npaRepository.existsById(id)) {
            throw new DataNotFoundException("Nsfr with ID " + id + " not found.");
        }

		updatedNpa.setId(id); // Ensure the ID remains the same
       return npaRepository.save(updatedNpa);
	}
	
}
