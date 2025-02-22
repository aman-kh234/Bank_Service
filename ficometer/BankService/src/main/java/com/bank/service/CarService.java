package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.bank.modal.Car;
import com.bank.modal.Roa;

@Service
public interface CarService {

    public Car addCar(Car car);

    public double calculateCarDepreciation(Car car);

    public Car getLatestCarByManufactureDate();

    public void deleteCar(int id);
    
    public List<Car> allCar(int n);

	public Car editCar(int id, Car updatedCar);
}
