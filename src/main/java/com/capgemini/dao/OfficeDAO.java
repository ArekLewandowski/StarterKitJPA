package com.capgemini.dao;

import java.util.List;
import java.util.Set;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.OfficeEntity;

public interface OfficeDAO extends Dao<OfficeEntity, Long>{
	
	List<EmployeeEntity> addEmployee(OfficeEntity officeEntity, EmployeeEntity employeeEntity);
	void removeEmployee(OfficeEntity officeEntity, EmployeeEntity employeeEntity);
	List<EmployeeEntity> getEmployies(OfficeEntity officeEntity);
	
}