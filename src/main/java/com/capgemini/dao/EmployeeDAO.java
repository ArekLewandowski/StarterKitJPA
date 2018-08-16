package com.capgemini.dao;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDAO extends Dao<EmployeeEntity, Long>{
	
	void addCar(Long id);
}
