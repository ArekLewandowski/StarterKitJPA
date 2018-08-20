package com.capgemini.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.CarDAO;
import com.capgemini.dao.EmployeeDAO;
import com.capgemini.dao.OfficeDAO;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.OfficeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.mappers.OfficeMapper;
import com.capgemini.service.OfficeService;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.OfficeTO;

@Service
@Transactional
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	OfficeDAO officeDao;

	@Autowired
	EmployeeDAO employeeDAO;

	@Autowired
	CarDAO carDAO;

	@Override
	public OfficeTO addOffice(OfficeTO officeTO) {
		OfficeEntity officeEntity = officeDao.save(OfficeMapper.map2Entity(officeTO));
		officeTO = OfficeMapper.map2TO(officeEntity);
		return officeTO;
	}

	@Override
	public OfficeTO deleteOffice(OfficeTO officeTO) {
		officeDao.delete(officeTO.getId());
		return officeTO;
	}

	@Override
	public OfficeTO updateOffice(OfficeTO officeTO) {
		OfficeEntity officeEntity = officeDao.getOne(officeTO.getId());
		officeDao.update(OfficeMapper.map2Entity(officeTO, officeEntity));
		return officeTO;
	}

	@Override
	public List<EmployeeTO> addEmployeeToOffice(OfficeTO officeTO, EmployeeTO employee) {
		EmployeeEntity employeeEntity = employeeDAO.getOne(employee.getId());
		OfficeEntity officeEntity = officeDao.getOne(officeTO.getId());
		List<EmployeeTO> employies = EmployeeMapper.map2TOs(officeDao.addEmployee(officeEntity, employeeEntity));
		return employies;
	}

	@Override
	public EmployeeTO removeEmployeeFromOffice(OfficeTO officeTO, EmployeeTO employee) {
		EmployeeEntity employeeEntity = employeeDAO.findOne(employee.getId());
		OfficeEntity officeEntity = officeDao.getOne(officeTO.getId());
		officeDao.removeEmployee(officeEntity, employeeEntity);
		return employee;
	}

	@Override
	public List<EmployeeTO> getAllOfficeEmployies(OfficeTO officeTO) {
		OfficeEntity officeEntity = officeDao.getOne(officeTO.getId());
		List<EmployeeEntity> employiesEntity = officeDao.getEmployies(officeEntity);
		List<EmployeeTO> employiesTO = new LinkedList<>();
		for (EmployeeEntity employeeEntity : employiesEntity) {
			EmployeeTO employeeTO = EmployeeMapper.map2TO(employeeEntity);
			employiesTO.add(employeeTO);
		}
		return employiesTO;
	}

	@Override
	public List<EmployeeTO> getOfficeEmployiesByCar(OfficeTO officeTO, CarTO carTO) {
		OfficeEntity officeEntity = officeDao.getOne(officeTO.getId());
		CarEntity carEntity = carDAO.findOne(carTO.getId());
		List<EmployeeEntity> employiesEntity = officeDao.getEmployies(officeEntity);
		List<EmployeeTO> employiesTO = new LinkedList<>();
		for (EmployeeEntity employeeEntity : employiesEntity) {
			if (employeeEntity.getCars().contains(carEntity)) {
				employiesTO.add(EmployeeMapper.map2TO(employeeEntity));
			}
		}
		return employiesTO;
	}

	@Override
	public OfficeTO getOffice(Long id) {
		OfficeTO officeTO = OfficeMapper.map2TO(officeDao.getOne(id));
		return officeTO;
	}

	@Override
	public List<OfficeTO> getAllOffices() {
		List<OfficeTO> officeTOs = OfficeMapper.map2TOs(officeDao.findAll());
		return officeTOs;
	}

}
