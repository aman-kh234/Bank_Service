package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.modal.Npa;
import com.bank.modal.Nsfr;

@Repository
public interface NsfrRepo extends JpaRepository<Nsfr,Integer>{
	public Nsfr findById(int id);
	@Query("SELECT l FROM Nsfr l ORDER BY l.period DESC LIMIT 1")
	public Nsfr getNsfrByPeriod();
	
	@Query(value = "SELECT * FROM Nsfr ORDER BY period DESC LIMIT :n", nativeQuery = true)
	List<Nsfr> getNsfrByMonthPeriod(@Param("n") int n);
}
