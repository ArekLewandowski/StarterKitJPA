package com.capgemini.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDAO;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.EmployeeService;
import com.capgemini.types.EmployeeTO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public EmployeeTO addEmployee(EmployeeTO employeeTO) {
		EmployeeEntity employeeEntity = EmployeeMapper.map2Entity(employeeTO);
		employeeEntity = employeeDAO.save(employeeEntity);
		return EmployeeMapper.map2TO(employeeEntity);
	}

	@Override
	public EmployeeTO deleteEmployee(EmployeeTO employeeTO) {
		Long id = employeeTO.getId();
		employeeDAO.delete(id);
		return employeeTO;
	}

	@Override
	public EmployeeTO updateEmployee(EmployeeTO employeeTO) {
		EmployeeEntity employeeEntity = employeeDAO.getOne(employeeTO.getId());
		employeeDAO.update(EmployeeMapper.map2Entity(employeeTO, employeeEntity));
		return employeeTO;
	}

	@Override
	public List<EmployeeTO> getEmployiesByPosition(String position) {
		List<EmployeeEntity> employies = employeeDAO.getEmployiesByPosition(position);
		return EmployeeMapper.map2TOs(employies);
	}
}
