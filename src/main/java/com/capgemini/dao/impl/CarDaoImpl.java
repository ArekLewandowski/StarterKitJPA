package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDAO;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
@Transactional
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDAO {

	@Override
	public void addEmployee(CarEntity carEntity, EmployeeEntity employeeEntity) {
		carEntity.addEmployee(employeeEntity);
		employeeEntity.addCar(carEntity);
	}

	@Override
	public List<CarEntity> getByBrand(String brand) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select car from CarEntity car where upper(car.brand) like concat(upper(:brand), '%')",
				CarEntity.class);
		query.setParameter("brand", brand);
		return query.getResultList();
	}

	@Override
	public List<CarEntity> getByType(String type) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select car from CarEntity car where upper(car.type) like concat(upper(:type), '%')", CarEntity.class);
		query.setParameter("type", type);
		return query.getResultList();
	}

}
