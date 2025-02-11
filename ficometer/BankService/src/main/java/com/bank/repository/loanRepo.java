package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.modal.Loan;

@Repository
public interface loanRepo extends JpaRepository<Loan,Integer>{
	public Loan findById(int id);
}
