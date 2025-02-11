package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.modal.Npa;

@Repository
public interface NpaRepo extends JpaRepository<Npa,Integer>{
	public Npa findById(int id);
	@Query("SELECT l FROM Npa l ORDER BY l.period DESC LIMIT 1")
	public Npa getNpaByPeriod();
}
