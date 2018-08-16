package com.capgemini.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDAO;
import com.capgemini.domain.EmployeeEntity;

@Repository
@Transactional
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addCar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
