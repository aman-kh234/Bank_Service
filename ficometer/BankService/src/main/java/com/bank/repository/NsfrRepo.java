package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.modal.Nsfr;

@Repository
public interface NsfrRepo extends JpaRepository<Nsfr,Integer>{
	public Nsfr findById(int id);
	@Query("SELECT l FROM Nsfr l ORDER BY l.period DESC LIMIT 1")
	public Nsfr getNsfrByPeriod();
}
