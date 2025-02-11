package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.modal.Roe;

@Repository
public interface RoeRepo extends JpaRepository<Roe,Integer>{
	public Roe findById(int id);
	@Query("SELECT l FROM Roe l ORDER BY l.period DESC LIMIT 1")
	public Roe getRoeByPeriod();
}
