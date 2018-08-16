package com.capgemini.service;

import java.util.List;
import java.util.Set;

import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.OfficeTO;

public interface OfficeService {

	OfficeTO addOffice(OfficeTO officeTO);
	OfficeTO deleteOffice(OfficeTO officeTO);
	OfficeTO getOffice(Long id);
	OfficeTO updateOffice(OfficeTO officeTO);
	OfficeTO addEmployeeToOffice(OfficeTO officeTO, EmployeeTO employee);
	OfficeTO removeEmployeeFromOffice(OfficeTO officeTO, EmployeeTO employee);
	
	Set<EmployeeTO> getAllOfficeEmployies(OfficeTO officeTO);
	Set<EmployeeTO> getOfficeEmployiesByCar(OfficeTO officeTO, CarTO carTO);
	List<OfficeTO> getAllOffices();
}
