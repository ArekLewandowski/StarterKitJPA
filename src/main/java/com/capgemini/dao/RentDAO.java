package com.capgemini.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.domain.RentEntity;

public interface RentDAO extends Dao<RentEntity, Long>{

	List<RentEntity> countRentedCars(Date date);

	List<RentEntity> carsRentedMoreThan(int times);

}
