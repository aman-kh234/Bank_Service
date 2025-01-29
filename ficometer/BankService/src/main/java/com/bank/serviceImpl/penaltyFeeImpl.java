package com.bank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.modal.PenaltyFees;
import com.bank.repository.feesRepo;
import com.bank.service.penaltyFeesService;

@Service
public class penaltyFeeImpl implements penaltyFeesService{
	@Autowired
	private feesRepo feesRepository;
	
	@Override
	public String addPenalty(PenaltyFees penalty) {
		feesRepository.save(penalty);
		return "Data is saved";
	}
	
	@Override
	public PenaltyFees updatePenalty(PenaltyFees penalty) throws Exception {
		if(feesRepository.findById(penalty.getPenaltyId())!=null) {
			return feesRepository.save(penalty);
		}
		else {
			throw new Exception("Id not found" + penalty.getPenaltyId());
		}
	}

	@Override
	public void deletePenalty(int id) throws Exception {
		if(feesRepository.findById(id)!=null)
		{
			feesRepository.deleteById(id);
		}
		else {
			throw new Exception("Id not found");
		}
	}
}
