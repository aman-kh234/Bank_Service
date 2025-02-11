package com.bank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.modal.Loan;
import com.bank.modal.PenaltyFees;
import com.bank.repository.feesRepo;
import com.bank.repository.loanRepo;
import com.bank.service.loanService;
import com.bank.service.penaltyFeesService;

@Service
public class loanServiceImpl implements loanService{
	@Autowired
	private loanRepo loanRepository;
	
	@Override
	public String addLoan(Loan loan) {
		loanRepository.save(loan);
		return "Data is saved";
	}
	
	@Override
	public Loan updateLoan(Loan loan) throws Exception {
		if(loanRepository.findById(loan.getId())!=null) {
			return loanRepository.save(loan);
		}
		else {
			throw new Exception("Id not found" + loan.getId());
		}
	}

	@Override
	public void deleteLoan(int id) throws Exception {
		if(loanRepository.findById(id)!=null)
		{
			loanRepository.deleteById(id);
		}
		else {
			throw new Exception("Id not found");
		}
	}
}
