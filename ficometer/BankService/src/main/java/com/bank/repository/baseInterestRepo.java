package com.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.modal.BaseInterest;
import com.bank.modal.PenaltyFees;

@Repository
public interface baseInterestRepo extends JpaRepository<BaseInterest,Integer>{
	public BaseInterest findById(int id);
	Optional<BaseInterest> findTopByOrderByIdDesc();
}
