package com.capgemini.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.RentEntity;

public interface RentDAO extends Dao<RentEntity, Long> {

	Long countRentedCars(Date startDateTime, Date endDateTime);

	List<CarEntity> carsRentedMoreThan(long times);

}
