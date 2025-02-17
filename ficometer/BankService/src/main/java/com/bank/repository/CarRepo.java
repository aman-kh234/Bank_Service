package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.modal.Car;
import com.bank.modal.Npa;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

    public Car findById(int id);

    @Query("SELECT c FROM Car c ORDER BY c.period DESC LIMIT 1")
    public Car getLatestCarByManufactureDate();
    
    @Query(value = "SELECT * FROM Car ORDER BY period DESC LIMIT :n", nativeQuery = true)
	List<Car> getCarByMonthPeriod(@Param("n") int n);

}
