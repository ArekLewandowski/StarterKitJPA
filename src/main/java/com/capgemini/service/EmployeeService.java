package com.capgemini.service;

import java.util.List;

import com.capgemini.types.EmployeeTO;

public interface EmployeeService {
	
	EmployeeTO addEmployee(EmployeeTO employeeTO);
	EmployeeTO deleteEmployee(EmployeeTO employeeTO);
	EmployeeTO updateEmployee(EmployeeTO employeeTO);
	List<EmployeeTO> getEmployiesByPosition(String position);
}
