package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.types.CarTO;

import Enums.CAR_TYPE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
	
	@Autowired
	private CarService carService;

	@Test
	public void testShouldAddCar() {

		// given
		CarTO carTO = CarTO.builder()
				.brand("Toyota")
				.model("Rav4")
				.color("pink")
				.type(CAR_TYPE.SUV)
				.engineCapacity(2000)
				.engineForce(120).year(2016).mileage(1000).build();
		CarTO addedCar = carService.addCar(carTO);
		

		// when
		CarTO selectedCar = carService.getCar(1L);

		// then
		assertNotNull(selectedCar);
		assertEquals(addedCar.getBrand(), "Toyota");
	}
	
	@Test
	public void testShouldRemoveCar() {

		// given
		CarTO carTO = CarTO.builder()
				.brand("Toyota")
				.model("Rav4")
				.color("pink")
				.type(CAR_TYPE.SUV)
				.engineCapacity(2000)
				.engineForce(120)
				.year(2016)
				.mileage(1000)
				.build();
		carService.addCar(carTO);
		
		CarTO carTO1 = CarTO.builder()
				.brand("Toyota")
				.model("Yaris")
				.color("blue")
				.type(CAR_TYPE.CITY)
				.engineCapacity(1000)
				.engineForce(80)
				.year(2015)
				.mileage(10000)
				.build();
		carService.addCar(carTO1);
		
		CarTO carTO2 = CarTO.builder()
				.brand("Honda")
				.model("Civic")
				.color("black")
				.type(CAR_TYPE.HATCHBACK)
				.engineCapacity(1600)
				.engineForce(100)
				.year(2016)
				.mileage(5000)
				.build();
		carService.addCar(carTO2);
		

		// when
		carService.deleteCar(carTO1);

		// then
		assertNotNull(carTO2);
		assertEquals("Honda", carTO2.getBrand());
		assertEquals(2, carService.getAllCars().size());
	}
	
	@Test
	public void testUpdateCar() {

		// given
		CarTO carTO = CarTO.builder()
				.brand("Toyota")
				.model("Rav4")
				.color("pink")
				.type(CAR_TYPE.SUV)
				.engineCapacity(2000)
				.engineForce(120)
				.year(2016)
				.mileage(1000)
				.build();
		carService.addCar(carTO);
		
		CarTO carTO1 = CarTO.builder()
				.brand("Toyota")
				.model("Yaris")
				.color("blue")
				.type(CAR_TYPE.CITY)
				.engineCapacity(1000)
				.engineForce(80)
				.year(2015)
				.mileage(10000)
				.build();
		carService.addCar(carTO1);
		
		CarTO carTO2 = CarTO.builder()
				.brand("Honda")
				.model("Civic")
				.color("black")
				.type(CAR_TYPE.HATCHBACK)
				.engineCapacity(1600)
				.engineForce(100)
				.year(2016)
				.mileage(5000)
				.build();
		carService.addCar(carTO2);
		

		// when

		// then
		assertNotNull(carTO2);
		assertEquals("Honda", carTO2.getBrand());
	}
	
}
