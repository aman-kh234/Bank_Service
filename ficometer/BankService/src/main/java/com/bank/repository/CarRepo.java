package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.modal.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

    public Car findById(int id);

    @Query("SELECT c FROM Car c ORDER BY c.period DESC LIMIT 1")
    public Car getLatestCarByManufactureDate();
}
