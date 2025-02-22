package com.bank.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.modal.Npa;
import com.bank.modal.Nsfr;
import com.bank.modal.Roa;

@Repository
public interface RoaRepo extends JpaRepository<Roa,Integer>{
	public Roa findById(int id);
	@Query("SELECT l FROM Roa l ORDER BY l.period DESC LIMIT 1")
	public Roa getRoaByPeriod();
    public int countByPeriod(LocalDate period);

	@Query(value = "SELECT * FROM Roa ORDER BY period DESC LIMIT :n", nativeQuery = true)
	List<Roa> getRoaByMonthPeriod(@Param("n") int n);

}
