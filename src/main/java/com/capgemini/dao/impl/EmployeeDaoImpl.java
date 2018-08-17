package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDAO;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
@Transactional
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDAO{

	@Override
	public List<EmployeeEntity> getEmployiesByPosition(String position) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"select employee from EmployeeEntity employee where upper(employee.position) like concat(upper(:position), '%')", EmployeeEntity.class);
        query.setParameter("position", position);
        return query.getResultList();
	}

}
