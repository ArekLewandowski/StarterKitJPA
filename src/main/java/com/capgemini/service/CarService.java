package com.capgemini.service;

import java.util.List;

import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

import Enums.CAR_TYPE;

public interface CarService {

	CarTO addCar(CarTO car);
	CarTO deleteCar(CarTO car);
	CarTO updateCar(CarTO car);
	CarTO getCar(Long id);
	CarTO setEmployee(CarTO car, EmployeeTO employee);
	List<CarTO> getAllCars();	
	List<CarTO> getCarByType(CAR_TYPE type);	
	List<CarTO> getCarByBrand(String brand);
	List<CarTO> getCarByEmployee(EmployeeTO employee);
	
}
