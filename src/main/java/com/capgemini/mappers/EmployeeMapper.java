package com.capgemini.mappers;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.EmployeeTO;

public class EmployeeMapper {

	public static EmployeeTO map2TO(EmployeeEntity employeeEntity) {
		EmployeeTO employeeTO = new EmployeeTO();
		employeeTO.setId(employeeEntity.getId());
		employeeTO.setFirstName(employeeEntity.getFirstName());
		employeeTO.setLastName(employeeEntity.getLastName());
		employeeTO.setPosition(employeeEntity.getPosition());
		employeeTO.setAge(employeeEntity.getAge());
		return employeeTO;
	}
	
	public static EmployeeEntity map2Entity(EmployeeTO employeeTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(employeeTO.getId());
		employeeEntity.setFirstName(employeeTO.getFirstName());
		employeeEntity.setLastName(employeeTO.getLastName());
		employeeEntity.setPosition(employeeTO.getPosition());
		employeeEntity.setAge(employeeTO.getAge());
		return employeeEntity;
	}
	
	public static List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		List<EmployeeTO> employeeTOs = new LinkedList<>();
		for (EmployeeEntity employeeEntity : employeeEntities) {
			EmployeeTO employeeTO = map2TO(employeeEntity);
			employeeTOs.add(employeeTO);
		}
		return employeeTOs;
	}
	
	public static List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTOs){
		List<EmployeeEntity> employeeEntities = new LinkedList<>();
		for (EmployeeTO employeeTO : employeeTOs) {
			EmployeeEntity employeeEntity = map2Entity(employeeTO);
			employeeEntities.add(employeeEntity);
		}
		return employeeEntities;
	}
}
