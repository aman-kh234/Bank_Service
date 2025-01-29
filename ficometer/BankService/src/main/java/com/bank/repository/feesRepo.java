package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.modal.PenaltyFees;

@Repository
public interface feesRepo extends JpaRepository<PenaltyFees,Integer>{
	public PenaltyFees findById(int id);
}
