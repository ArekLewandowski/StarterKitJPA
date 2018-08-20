package com.capgemini.service;

import java.util.Date;
import java.util.List;

import com.capgemini.types.CarTO;
import com.capgemini.types.RentTO;

public interface RentService {

	RentTO addRent(RentTO rentTO);

	RentTO getOne(Long id);

	List<CarTO> getCarsRentedMoreThanXTimes(long times);

	Long countRentedCars(Date startDateTime, Date endtDateTime);
}
