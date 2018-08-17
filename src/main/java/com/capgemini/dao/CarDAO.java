package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

import Enums.CAR_TYPE;

public interface CarDAO extends Dao<CarEntity, Long>{

	void addEmployee(CarEntity carEntity, EmployeeEntity employeeEntity);
	List<CarEntity> getByBrand(String brand);
	List<CarEntity> getByType(CAR_TYPE type);
}
