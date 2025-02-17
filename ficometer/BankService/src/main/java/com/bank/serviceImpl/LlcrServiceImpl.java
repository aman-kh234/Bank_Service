package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return llcrRepository.save(llcr);
    }

    @Override
    public Llcr getLlcrByPeriod() {
        return llcrRepository.getLlcrByPeriod();
    }

    @Override
    public void deleteLlcr(int id) {
        llcrRepository.deleteById(id);
    }

	@Override
	public List<Llcr> allLlcr(int n) {
		return llcrRepository.getLlcrByMonthPeriod(n);
	}
}
