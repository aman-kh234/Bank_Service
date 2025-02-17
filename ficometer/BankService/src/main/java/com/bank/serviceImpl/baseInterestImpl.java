package com.bank.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.modal.BaseInterest;
import com.bank.repository.baseInterestRepo;
import com.bank.service.baseInterest;

@Service
public class baseInterestImpl implements baseInterest{
	@Autowired
	private baseInterestRepo baseInterestRepository;
	
	@Override
	public String addBaseInterest(BaseInterest interest) {
		baseInterestRepository.save(interest);
		return "Data is saved";
	}
	
	@Override
	public BaseInterest updatebaseInterest(BaseInterest interest) throws Exception {
		if(baseInterestRepository.findById(interest.getId())!=null) {
			return baseInterestRepository.save(interest);
		}
		else {
			throw new Exception("Id not found" + interest.getId());
		}
	}

	@Override
	public void deleteBaseInterest(int id) throws Exception {
		if(baseInterestRepository.findById(id)!=null)
		{
			baseInterestRepository.deleteById(id);
		}
		else {
			throw new Exception("Id not found");
		}
	}

	@Override
    public BaseInterest getLatestBaseInterest() {
        // Assuming only one record exists or fetching the latest one
        Optional<BaseInterest> latestInterest = baseInterestRepository.findTopByOrderByIdDesc();
        return latestInterest.orElse(null);
    }
}
