package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.DataAlreadyExistsException;
import com.bank.exception.DataNotFoundException;
import com.bank.modal.Car;
import com.bank.repository.CarRepo;
import com.bank.service.CarService;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepository;

    @Override
    public double calculateCarDepreciation(Car car) {
    	double T1 = car.getTier1();
        double T2 = car.getTier2();
    	double RA = car.getRiskAssets();
    	double total = T1 + T2;
    	double ans  = (total/RA)*100;
    	
    	return ans;
    }

    @Override
    public Car addCar(Car car) {
//        return carRepository.save(car);
        
        int count = carRepository.countByPeriod(car.getPeriod());  
	      
	    if (count > 0) {  
	        throw new DataAlreadyExistsException("Data for period " + car.getPeriod() + " already exists. You can only modify it.");  
	    }  
	      
	    return carRepository.save(car); 
    }

    @Override
    public Car getLatestCarByManufactureDate() {
        return carRepository.getLatestCarByManufactureDate();
    }

    @Override
    public void deleteCar(int id) {
    	if (!carRepository.existsById(id)) {
            throw new DataNotFoundException("Car with ID " + id + " not found.");
        }
        carRepository.deleteById(id);
    }

	@Override
	public List<Car> allCar(int n) {
		return carRepository.getCarByMonthPeriod(n);
	}

	@Override
	public Car editCar(int id, Car updatedCar) {
		if (!carRepository.existsById(id)) {
            throw new DataNotFoundException("Llcr with ID " + id + " not found.");
        }

		updatedCar.setId(id); // Ensure the ID remains the same
       return carRepository.save(updatedCar);
		

	}
}
