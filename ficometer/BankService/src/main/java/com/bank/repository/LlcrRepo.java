package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.modal.Llcr;
import com.bank.modal.Nsfr;

@Repository
public interface LlcrRepo extends JpaRepository<Llcr,Integer>{
	public Llcr findById(int id);
	@Query("SELECT l FROM Llcr l ORDER BY l.period DESC LIMIT 1")
	public Llcr getLlcrByPeriod();
}
