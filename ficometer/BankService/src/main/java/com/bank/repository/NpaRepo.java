package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.modal.Npa;

@Repository
public interface NpaRepo extends JpaRepository<Npa,Integer>{
	public Npa findById(int id);
	@Query("SELECT l FROM Npa l ORDER BY l.period DESC LIMIT 1")
	public Npa getNpaByPeriod();
	
	@Query(value = "SELECT * FROM Npa ORDER BY period DESC LIMIT :n", nativeQuery = true)
	List<Npa> getNpaByMonthPeriod(@Param("n") int n);

}
