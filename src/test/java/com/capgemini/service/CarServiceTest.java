package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

import Enums.CAR_TYPE;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private EmployeeService employeeService;

	@Transactional
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
		CarTO selectedCar = carService.getCar(addedCar.getId());

		// then
		assertNotNull(selectedCar);
		assertEquals(addedCar.getBrand(), "Toyota");
	}
	
	@Transactional
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
		CarTO updatedCar = carService.addCar(carTO);
		
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
		CarTO updatedCar1 = carService.addCar(carTO1);
		
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
		CarTO updatedCar2 = carService.addCar(carTO2);
		

		// when
		carService.deleteCar(updatedCar.getId());

		// then
		assertEquals("Honda", carTO2.getBrand());
		assertEquals(2, carService.getAllCars().size());
	}
	
	@Transactional
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
		CarTO updatedCar = carService.addCar(carTO);
		
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
		CarTO updatedCar1 = carService.addCar(carTO1);
		
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
		CarTO updatedCar2 = carService.addCar(carTO2);
		updatedCar1.setColor("red");

		// when
		carService.updateCar(updatedCar1);

		// then
		assertNotNull(updatedCar1);
		assertEquals("red", carService.getCar(updatedCar1.getId()).getColor());
	}
	
	@Transactional
	@Test
	public void testGetCarByBrand() {

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
		CarTO updatedCar = carService.addCar(carTO);
		
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
		CarTO updatedCar1 = carService.addCar(carTO1);
		
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
		CarTO updatedCar2 = carService.addCar(carTO2);

		// when
		List<CarTO> cars = carService.getCarByBrand("Toyota");

		// then
		System.out.println(cars);
		assertNotNull(cars);
		assertEquals("Toyota", cars.get(0).getBrand());
	}
	
	@Transactional
	@Test
	public void testGetCarByType() {

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
		CarTO updatedCar = carService.addCar(carTO);
		
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
		CarTO updatedCar1 = carService.addCar(carTO1);
		
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
		CarTO updatedCar2 = carService.addCar(carTO2);

		// when
		List<CarTO> cars = carService.getCarByType(CAR_TYPE.SUV);

		// then
		System.out.println(cars);
		assertNotNull(cars);
		assertEquals(CAR_TYPE.SUV, cars.get(1).getType());
		assertEquals(1, cars.size());
	}
	
	@Transactional
	@Test
	public void testAddCarToEmployee() {

		// given
		CarTO carTO = CarTO.builder().brand("Toyota").model("Rav4").color("pink")
				.type(CAR_TYPE.SUV).engineCapacity(2000).engineForce(120).year(2016).mileage(1000)
				.build();
		CarTO updatedCar = carService.addCar(carTO);
		
		CarTO carTO1 = CarTO.builder().brand("Toyota").model("Yaris").color("blue")
				.type(CAR_TYPE.CITY).engineCapacity(1000).engineForce(80).year(2015).mileage(10000)
				.build();
		CarTO updatedCar1 = carService.addCar(carTO1);
		
		CarTO carTO2 = CarTO.builder().brand("Honda").model("Civic").color("black")
				.type(CAR_TYPE.HATCHBACK).engineCapacity(1600).engineForce(100).year(2016).mileage(5000)
				.build();
		CarTO updatedCar2 = carService.addCar(carTO2);
		
		EmployeeTO employee1 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName", "lastName", "position", 44));
		EmployeeTO employee2 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName2", "lastName2", "position", 32));


		// when
		carService.setEmployee(updatedCar, employee1);
		List<CarTO> cars = carService.getCarByEmployee(employee1);
		

		// then
		assertNotNull(cars);

	}
	
	@Transactional
	@Test
	public void testGetCarByEmployee() {

		// given
		CarTO carTO = CarTO.builder().brand("Toyota").model("Rav4").color("pink")
				.type(CAR_TYPE.SUV).engineCapacity(2000).engineForce(120).year(2016).mileage(1000)
				.build();
		CarTO updatedCar = carService.addCar(carTO);
		
		CarTO carTO1 = CarTO.builder().brand("Toyota").model("Yaris").color("blue")
				.type(CAR_TYPE.CITY).engineCapacity(1000).engineForce(80).year(2015).mileage(10000)
				.build();
		CarTO updatedCar1 = carService.addCar(carTO1);
		
		CarTO carTO2 = CarTO.builder().brand("Honda").model("Civic").color("black")
				.type(CAR_TYPE.HATCHBACK).engineCapacity(1600).engineForce(100).year(2016).mileage(5000)
				.build();
		CarTO updatedCar2 = carService.addCar(carTO2);
		
		EmployeeTO employee1 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName", "lastName", "position", 44));
		EmployeeTO employee2 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName2", "lastName2", "position", 32));


		// when
		carService.setEmployee(updatedCar, employee1);
		List<CarTO> cars = carService.getCarByEmployee(employee1);
		

		// then
		assertEquals(CAR_TYPE.SUV, cars.get(0).getType());
		assertEquals(1, cars.size());
	}
	
}
