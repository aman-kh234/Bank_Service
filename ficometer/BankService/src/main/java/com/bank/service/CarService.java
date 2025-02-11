package com.bank.service;

import org.springframework.stereotype.Service;
import com.bank.modal.Car;

@Service
public interface CarService {

    public Car addCar(Car car);

    public double calculateCarDepreciation(Car car);

    public Car getLatestCarByManufactureDate();

    public void deleteCar(int id);
}
