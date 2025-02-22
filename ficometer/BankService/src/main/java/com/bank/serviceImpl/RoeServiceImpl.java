package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.DataAlreadyExistsException;
import com.bank.exception.DataNotFoundException;
import com.bank.modal.Roe;
import com.bank.repository.RoeRepo;
import com.bank.service.RoeService;

@Service
public class RoeServiceImpl implements RoeService{
	@Autowired
	private RoeRepo roeRepository;
	
	@Override
	public Roe addRoe(Roe roe) {
//		return roeRepository.save(roe);
		
		int count = roeRepository.countByPeriod(roe.getPeriod());  
	      
	    if (count > 0) {  
	        throw new DataAlreadyExistsException("Data for period " + roe.getPeriod() + " already exists. You can only modify it.");  
	    }  
	      
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
    public Roe editRoe(int id, Roe updatedRoe) {
        if (!roeRepository.existsById(id)) {
            throw new DataNotFoundException("Roe with ID " + id + " not found.");
        }

        updatedRoe.setId(id); // Ensure the ID remains the same
        return roeRepository.save(updatedRoe);
    }
	 
	@Override
	public void deleteRoe(int id) {
		  if (!roeRepository.existsById(id)) {
	            throw new DataNotFoundException("Roe with ID " + id + " not found.");
	        }
	       roeRepository.deleteById(id);
	}

	@Override
	public List<Roe> allRoe(int n) {
		return roeRepository.getRoeByMonthPeriod(n);
	}
	
}
