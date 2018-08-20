package com.capgemini.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.RentDAO;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.RentEntity;

@Repository
@Transactional
public class RentDaoImpl extends AbstractDao<RentEntity, Long> implements RentDAO {

	@Override
	public Long countRentedCars(Date startDateTime, Date endDateTime) {
		TypedQuery<Long> query = entityManager.createQuery(
					"SELECT COUNT(car) from CarEntity car JOIN car.rents rent "
	+"WHERE (rent.rentDate BETWEEN :startDateTime AND :endDateTime) OR "
	+"(rent.returnDate BETWEEN :startDateTime AND :endDateTime) OR "
	+ "(rent.rentDate < :startDateTime AND rent.returnDate > :endDateTime)", Long.class); 
		query.setParameter("startDateTime", startDateTime);
		query.setParameter("endDateTime", endDateTime);
		return query.getSingleResult();
	}
	


	@Override
	public List<CarEntity> carsRentedMoreThan(long times) {
		TypedQuery<CarEntity> query = entityManager
				.createQuery("SELECT cars FROM CarEntity cars JOIN cars.rents rents GROUP BY cars.id"
						+ " having COUNT(distinct rents.client.id) > :times)", CarEntity.class);
		query.setParameter("times", times);
		return query.getResultList();
	}
}
