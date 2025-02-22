package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.DataAlreadyExistsException;
import com.bank.exception.DataNotFoundException;
import com.bank.modal.Roa;
import com.bank.modal.Roe;
import com.bank.repository.RoaRepo;
import com.bank.service.RoaService;

@Service
public class RoaServiceImpl implements RoaService{
	@Autowired
	private RoaRepo roaRepository;
	@Override
	public Roa addRoa(Roa roa) {
//		return roaRepository.save(roa);
		
		int count = roaRepository.countByPeriod(roa.getPeriod());  
	      
	    if (count > 0) {  
	        throw new DataAlreadyExistsException("Data for period " + roa.getPeriod() + " already exists. You can only modify it.");  
	    }  
	      
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
    public Roa editRoa(int id, Roa updatedRoa) {
        if (!roaRepository.existsById(id)) {
            throw new DataNotFoundException("Roa with ID " + id + " not found.");
        }

        updatedRoa.setId(id); // Ensure the ID remains the same
        return roaRepository.save(updatedRoa);
    }
	
	@Override
	public void deleteRoa(int id) {
//		roaRepository.deleteById(id);
		
		  if (!roaRepository.existsById(id)) {
	            throw new DataNotFoundException("Roe with ID " + id + " not found.");
	        }
		  roaRepository.deleteById(id);
	}

	@Override
	public List<Roa> allRoa(int n) {
		return roaRepository.getRoaByMonthPeriod(n);
	}
	
}
