package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.DataAlreadyExistsException;
import com.bank.exception.DataNotFoundException;
import com.bank.modal.Llcr;
import com.bank.repository.LlcrRepo;
import com.bank.service.LlcrService;

@Service
public class LlcrServiceImpl implements LlcrService {

    @Autowired
    private LlcrRepo llcrRepository;

    
    @Override
    public double calculateLlcr(Llcr llcr) {
       double LLR = llcr.getLoanLossReserves();
       double NPL = llcr.getNonPerformingLoans();
       
       double ans  = (LLR/NPL)*100;
       return ans;
    }

    @Override
    public Llcr addLlcr(Llcr llcr) {
//        return llcrRepository.save(llcr);

    	int count = llcrRepository.countByPeriod(llcr.getPeriod());  
	      
	    if (count > 0) {  
	        throw new DataAlreadyExistsException("Data for period " + llcr.getPeriod() + " already exists. You can only modify it.");  
	    }  
	      
	    return llcrRepository.save(llcr); 
    }

    @Override
    public Llcr getLlcrByPeriod() {
        return llcrRepository.getLlcrByPeriod();
    }

    @Override
    public void deleteLlcr(int id) {
    	if (!llcrRepository.existsById(id)) {
            throw new DataNotFoundException("LLCR with ID " + id + " not found.");
        }
        llcrRepository.deleteById(id);
    }

	@Override
	public List<Llcr> allLlcr(int n) {
		return llcrRepository.getLlcrByMonthPeriod(n);
	}

	@Override
	public Llcr editLlcr(int id, Llcr updatedLlcr) {
		if (!llcrRepository.existsById(id)) {
            throw new DataNotFoundException("Llcr with ID " + id + " not found.");
        }

		updatedLlcr.setId(id); // Ensure the ID remains the same
       return llcrRepository.save(updatedLlcr);
	}
}
