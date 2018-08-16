package com.capgemini.dao.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDAO;
import com.capgemini.dao.OfficeDAO;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.OfficeEntity;

@Repository
@Transactional
public class OfficeDaoImpl extends AbstractDao<OfficeEntity, Long> implements OfficeDAO {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public void addEmployee(OfficeEntity officeEntity, EmployeeEntity employeeEntity) {
		employeeEntity.setOffice(officeEntity);
		officeEntity.addEmployee(employeeEntity);
	}

	@Override
	public void removeEmployee(OfficeEntity officeEntity, EmployeeEntity employeeEntity) {
		officeEntity.getEmployies().remove(employeeEntity);
		employeeEntity.setOffice(null);
	}

	@Override
	public Set<EmployeeEntity> getEmployies(OfficeEntity officeEntity) {
		Set<EmployeeEntity> employies = officeEntity.getEmployies();
		return employies;
	}

	
}
