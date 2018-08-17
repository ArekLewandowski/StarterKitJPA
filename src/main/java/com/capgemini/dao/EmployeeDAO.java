package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDAO extends Dao<EmployeeEntity, Long>{
	
	List<EmployeeEntity> getEmployiesByPosition(String position);
}
