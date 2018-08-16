package com.capgemini.dao;

import java.util.Set;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.OfficeEntity;

public interface OfficeDAO extends Dao<OfficeEntity, Long>{
	
	void addEmployee(OfficeEntity officeEntity, EmployeeEntity employeeEntity);
	void removeEmployee(OfficeEntity officeEntity, EmployeeEntity employeeEntity);
	Set<EmployeeEntity> getEmployies(OfficeEntity officeEntity);
	
}