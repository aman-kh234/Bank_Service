package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.modal.Nsfr;
import com.bank.modal.Roa;

@Repository
public interface RoaRepo extends JpaRepository<Roa,Integer>{
	public Roa findById(int id);
	@Query("SELECT l FROM Roa l ORDER BY l.period DESC LIMIT 1")
	public Roa getRoaByPeriod();
}
