package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.bank.modal.Car;

@Service
public interface CarService {

    public Car addCar(Car car);

    public double calculateCarDepreciation(Car car);

    public Car getLatestCarByManufactureDate();

    public void deleteCar(int id);
    
    public List<Car> allCar(int n);
}
