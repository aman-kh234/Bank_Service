package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.modal.Car;
import com.bank.modal.Npa;
import com.bank.service.CarService;

@RestController
@RequestMapping("/")
public class CarController {

    @Autowired
    private CarService carServiceImpl;

    @PostMapping("/add/car")
    public Car addCar(@RequestBody Car car) {
        return carServiceImpl.addCar(car);
    }

    @GetMapping("/get/carByPeriod")
    public Car getByPeriod() {
        return carServiceImpl.getLatestCarByManufactureDate();
    }

    @GetMapping("/calculate/carDepreciation/latest")
    public double calculateCarDepreciationLatest() {
        return carServiceImpl.calculateCarDepreciation(getByPeriod());
    }

    @DeleteMapping("/delete/car/{id}")
    public void deleteCar(@PathVariable int id) {
        carServiceImpl.deleteCar(id);
    }
    
    @GetMapping("/calculate/car/months/{n}")
    public List<Car> calculateAllCar(@PathVariable int n) {
        return carServiceImpl.allCar(n);
    }
}
