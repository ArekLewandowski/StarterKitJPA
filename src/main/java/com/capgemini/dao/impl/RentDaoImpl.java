package com.capgemini.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.RentDAO;
import com.capgemini.domain.RentEntity;

@Repository
@Transactional
public class RentDaoImpl extends AbstractDao<RentEntity, Long> implements RentDAO{
	
	@Override
	public List<RentEntity> countRentedCars(Date date) {
		 TypedQuery<RentEntity> query = entityManager.createQuery(
	                "select count(*) from RentEntity rents where rents.rentDate < :date, '%') group by rents.car", RentEntity.class);
		 query.setParameter("date", date);
	        return query.getResultList();
	}
	
	@Override
	public List<RentEntity> carsRentedMoreThan(int times) {
		 TypedQuery<RentEntity> query = entityManager.createQuery(
	                "select rents, count(*) as sum from RentEntity rents where rents.sum > :times, '%') group by rents.client", RentEntity.class);
		 query.setParameter("times", times);
	        return query.getResultList();
	}
}
