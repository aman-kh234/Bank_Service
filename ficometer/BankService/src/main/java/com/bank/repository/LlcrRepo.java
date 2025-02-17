package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.modal.Llcr;
import com.bank.modal.Npa;
import com.bank.modal.Nsfr;

@Repository
public interface LlcrRepo extends JpaRepository<Llcr,Integer>{
	public Llcr findById(int id);
	@Query("SELECT l FROM Llcr l ORDER BY l.period DESC LIMIT 1")
	public Llcr getLlcrByPeriod();
	
	@Query(value = "SELECT * FROM Llcr ORDER BY period DESC LIMIT :n", nativeQuery = true)
	List<Llcr> getLlcrByMonthPeriod(@Param("n") int n);

}
