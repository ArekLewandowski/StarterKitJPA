package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.types.CarTO;
import com.capgemini.types.ClientTO;
import com.capgemini.types.OfficeTO;
import com.capgemini.types.RentTO;

//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class RentsTests {

	@Autowired
	private RentService rentService;
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private ClientService clientService;
	
	@Test
	public void testShouldAddRent() {

		// given
		//Offices init
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		
		//Cars init
		CarTO carTO = CarTO.builder()
				.brand("Toyota")
				.model("Rav4")
				.color("pink")
				.type("SUV")
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
				.type("CITY")
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
				.type("HATCHBACK")
				.engineCapacity(1600)
				.engineForce(100)
				.year(2016)
				.mileage(5000)
				.build();
		CarTO updatedCar2 = carService.addCar(carTO2);
		
		//Client init
		ClientTO clientTO = new ClientTO();
		clientTO.setFirstName("Stefan");
		clientTO.setLastName("Nowak");
		clientTO.setAddres("Poznań");
		clientTO.setAddres("sn@email.pl");	
		clientTO = clientService.addClient(clientTO);
		
		//Rent init
		RentTO rentTO = new RentTO();
		rentTO.setCarTO(updatedCar);
		rentTO.setClientTO(clientTO);
		rentTO.setRentOfficeTO(addedOffice);
		rentTO.setReturnOfficeTO(addedOffice2);
		rentTO.setRentDate(java.sql.Date.valueOf("2016-01-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-01-10"));
		rentTO.setPrice(1000);
		


		// when
		
		RentTO savedRent = rentService.addRent(rentTO);

		// then
		assertNotNull(savedRent);
		assertEquals(updatedCar, rentService.getOne(savedRent.getId()).getCarTO());
	}
	
	@Test
	public void testShouldGet5Rents() {

		// given
		//Offices init
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		
		//Cars init
		CarTO carTO = CarTO.builder()
				.brand("Toyota")
				.model("Rav4")
				.color("pink")
				.type("SUV")
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
				.type("CITY")
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
				.type("HATCHBACK")
				.engineCapacity(1600)
				.engineForce(100)
				.year(2016)
				.mileage(5000)
				.build();
		CarTO updatedCar2 = carService.addCar(carTO2);
		
		//Client init
		ClientTO clientTO = new ClientTO();
		clientTO.setFirstName("Stefan");
		clientTO.setLastName("Nowak");
		clientTO.setAddres("Poznań");
		clientTO.setAddres("sn@email.pl");	
		ClientTO addedClient = clientService.addClient(clientTO);		

		ClientTO clientTO1 = new ClientTO();
		clientTO1.setFirstName("Jan");
		clientTO1.setLastName("Kowalski");
		clientTO1.setAddres("Poznań");
		clientTO1.setAddres("jk@email.pl");	
		ClientTO addedClient1 = clientService.addClient(clientTO1);		
		
		//Rents init
		RentTO rentTO = new RentTO();
		rentTO.setCarTO(updatedCar);
		rentTO.setClientTO(addedClient);
		rentTO.setRentOfficeTO(addedOffice);
		rentTO.setRentDate(java.sql.Date.valueOf("2016-01-01"));
		rentTO.setPrice(1000);
		RentTO savedRent = rentService.addRent(rentTO);
		
		
		RentTO rentTO1 = new RentTO();
		rentTO1.setCarTO(updatedCar1);
		rentTO1.setClientTO(addedClient1);
		rentTO1.setRentOfficeTO(addedOffice);
		rentTO1.setRentDate(java.sql.Date.valueOf("2016-02-01"));
		rentTO1.setPrice(1000);
		RentTO savedRent1 = rentService.addRent(rentTO1);
		
		RentTO rentTO2 = new RentTO();
		rentTO2.setCarTO(updatedCar);
		rentTO2.setClientTO(addedClient1);
		rentTO2.setRentOfficeTO(addedOffice);
		rentTO2.setRentDate(java.sql.Date.valueOf("2016-02-21"));
		rentTO2.setPrice(1000);
		RentTO savedRent2 = rentService.addRent(rentTO2);
		
		
		RentTO rentTO3 = new RentTO();
		rentTO3.setCarTO(updatedCar1);
		rentTO3.setClientTO(addedClient1);
		rentTO3.setRentOfficeTO(addedOffice);
		rentTO3.setRentDate(java.sql.Date.valueOf("2016-03-01"));
		rentTO3.setPrice(1000);
		RentTO savedRent3 = rentService.addRent(rentTO3);
		
		RentTO rentTO4 = new RentTO();
		rentTO4.setCarTO(updatedCar);
		rentTO4.setClientTO(addedClient1);
		rentTO4.setRentOfficeTO(addedOffice);
		rentTO4.setRentDate(java.sql.Date.valueOf("2016-03-11"));
		rentTO4.setPrice(1000);
		RentTO savedRent4 = rentService.addRent(rentTO4);
		
		
		RentTO rentTO5 = new RentTO();
		rentTO5.setCarTO(updatedCar1);
		rentTO5.setClientTO(addedClient1);
		rentTO5.setRentOfficeTO(addedOffice);
		rentTO5.setRentDate(java.sql.Date.valueOf("2016-04-01"));
		rentTO5.setPrice(1000);
		RentTO savedRent5 = rentService.addRent(rentTO5);
		
		RentTO rentTO6 = new RentTO();
		rentTO6.setCarTO(updatedCar1);
		rentTO6.setClientTO(addedClient);
		rentTO6.setRentOfficeTO(addedOffice);
		rentTO6.setRentDate(java.sql.Date.valueOf("2016-05-01"));
		rentTO6.setPrice(1000);
		RentTO savedRent6 = rentService.addRent(rentTO6);
		
		
		RentTO rentTO7 = new RentTO();
		rentTO7.setCarTO(updatedCar1);
		rentTO7.setClientTO(addedClient1);
		rentTO7.setRentOfficeTO(addedOffice);
		rentTO7.setRentDate(java.sql.Date.valueOf("2016-06-01"));
		rentTO7.setPrice(1000);
		RentTO savedRent7 = rentService.addRent(rentTO7);
		
		RentTO rentTO8 = new RentTO();
		rentTO8.setCarTO(updatedCar2);
		rentTO8.setClientTO(addedClient1);
		rentTO8.setRentOfficeTO(addedOffice);
		rentTO8.setRentDate(java.sql.Date.valueOf("2016-06-11"));
		rentTO8.setPrice(1000);
		RentTO savedRent8 = rentService.addRent(rentTO8);
		
		
		RentTO rentTO9 = new RentTO();
		rentTO9.setCarTO(updatedCar1);
		rentTO9.setClientTO(addedClient1);
		rentTO9.setRentOfficeTO(addedOffice);
		rentTO9.setRentDate(java.sql.Date.valueOf("2016-06-14"));
		rentTO9.setPrice(1000);
		RentTO savedRent9 = rentService.addRent(rentTO9);
		
		RentTO rentTO10 = new RentTO();
		rentTO10.setCarTO(updatedCar1);
		rentTO10.setClientTO(addedClient);
		rentTO10.setRentOfficeTO(addedOffice);
		rentTO10.setRentDate(java.sql.Date.valueOf("2016-07-01"));
		rentTO10.setPrice(1000);
		RentTO savedRent10 = rentService.addRent(rentTO10);
		
		
		RentTO rentTO11 = new RentTO();
		rentTO11.setCarTO(updatedCar1);
		rentTO11.setClientTO(addedClient1);
		rentTO11.setRentOfficeTO(addedOffice);
		rentTO11.setRentDate(java.sql.Date.valueOf("2016-08-01"));
		rentTO11.setPrice(1000);
		RentTO savedRent11 = rentService.addRent(rentTO11);
		


		// when
		
		List<CarTO> result = rentService.getCarsRentedMoreThanXTimes(5L);
		
		// then
		assertNotNull(savedRent);
		assertEquals(0, result.size());
	}
	
	@Test
	public void testShouldGetRentsAmount() {

		// given
		//Offices init
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		
		//Cars init
		CarTO carTO = CarTO.builder()
				.brand("Toyota")
				.model("Rav4")
				.color("pink")
				.type("SUV")
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
				.type("CITY")
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
				.type("HATCHBACK")
				.engineCapacity(1600)
				.engineForce(100)
				.year(2016)
				.mileage(5000)
				.build();
		CarTO updatedCar2 = carService.addCar(carTO2);
		

		//Client init
		ClientTO clientTO = new ClientTO();
		clientTO.setFirstName("Stefan");
		clientTO.setLastName("Nowak");
		clientTO.setAddres("Poznań");
		clientTO.setAddres("sn@email.pl");	
		ClientTO addedClient = clientService.addClient(clientTO);		

		ClientTO clientTO1 = new ClientTO();
		clientTO1.setFirstName("Jan");
		clientTO1.setLastName("Kowalski");
		clientTO1.setAddres("Poznań");
		clientTO1.setAddres("jk@email.pl");	
		ClientTO addedClient1 = clientService.addClient(clientTO1);		
		
		//Rents init
		RentTO rentTO = new RentTO();
		rentTO.setCarTO(updatedCar);
		rentTO.setClientTO(addedClient);
		rentTO.setRentOfficeTO(addedOffice);
		rentTO.setRentDate(java.sql.Date.valueOf("2016-01-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-01-10"));
		rentTO.setPrice(1000);
		RentTO savedRent = rentService.addRent(rentTO);
		
		
		RentTO rentTO1 = new RentTO();
		rentTO1.setCarTO(updatedCar1);
		rentTO1.setClientTO(addedClient1);
		rentTO1.setRentOfficeTO(addedOffice);
		rentTO1.setRentDate(java.sql.Date.valueOf("2016-02-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-02-10"));
		rentTO1.setPrice(1000);
		RentTO savedRent1 = rentService.addRent(rentTO1);
		
		RentTO rentTO2 = new RentTO();
		rentTO2.setCarTO(updatedCar);
		rentTO2.setClientTO(addedClient1);
		rentTO2.setRentOfficeTO(addedOffice);
		rentTO2.setRentDate(java.sql.Date.valueOf("2016-02-21"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-03-10"));
		rentTO2.setPrice(1000);
		RentTO savedRent2 = rentService.addRent(rentTO2);
		
		
		RentTO rentTO3 = new RentTO();
		rentTO3.setCarTO(updatedCar1);
		rentTO3.setClientTO(addedClient1);
		rentTO3.setRentOfficeTO(addedOffice);
		rentTO3.setRentDate(java.sql.Date.valueOf("2016-03-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-03-10"));
		rentTO3.setPrice(1000);
		RentTO savedRent3 = rentService.addRent(rentTO3);
		
		RentTO rentTO4 = new RentTO();
		rentTO4.setCarTO(updatedCar);
		rentTO4.setClientTO(addedClient1);
		rentTO4.setRentOfficeTO(addedOffice);
		rentTO4.setRentDate(java.sql.Date.valueOf("2016-03-11"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-04-10"));
		rentTO4.setPrice(1000);
		RentTO savedRent4 = rentService.addRent(rentTO4);
		
		
		RentTO rentTO5 = new RentTO();
		rentTO5.setCarTO(updatedCar1);
		rentTO5.setClientTO(addedClient1);
		rentTO5.setRentOfficeTO(addedOffice);
		rentTO5.setRentDate(java.sql.Date.valueOf("2016-04-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-04-10"));
		rentTO5.setPrice(1000);
		RentTO savedRent5 = rentService.addRent(rentTO5);
		
		RentTO rentTO6 = new RentTO();
		rentTO6.setCarTO(updatedCar1);
		rentTO6.setClientTO(addedClient);
		rentTO6.setRentOfficeTO(addedOffice);
		rentTO6.setRentDate(java.sql.Date.valueOf("2016-05-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-05-10"));
		rentTO6.setPrice(1000);
		RentTO savedRent6 = rentService.addRent(rentTO6);
		
		
		RentTO rentTO7 = new RentTO();
		rentTO7.setCarTO(updatedCar1);
		rentTO7.setClientTO(addedClient1);
		rentTO7.setRentOfficeTO(addedOffice);
		rentTO7.setRentDate(java.sql.Date.valueOf("2016-06-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-06-10"));
		rentTO7.setPrice(1000);
		RentTO savedRent7 = rentService.addRent(rentTO7);
		
		RentTO rentTO8 = new RentTO();
		rentTO8.setCarTO(updatedCar2);
		rentTO8.setClientTO(addedClient1);
		rentTO8.setRentOfficeTO(addedOffice);
		rentTO8.setRentDate(java.sql.Date.valueOf("2016-06-11"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-07-10"));
		rentTO8.setPrice(1000);
		RentTO savedRent8 = rentService.addRent(rentTO8);
		
		
		RentTO rentTO9 = new RentTO();
		rentTO9.setCarTO(updatedCar1);
		rentTO9.setClientTO(addedClient1);
		rentTO9.setRentOfficeTO(addedOffice);
		rentTO9.setRentDate(java.sql.Date.valueOf("2016-06-14"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-07-10"));
		rentTO9.setPrice(1000);
		RentTO savedRent9 = rentService.addRent(rentTO9);
		
		RentTO rentTO10 = new RentTO();
		rentTO10.setCarTO(updatedCar1);
		rentTO10.setClientTO(addedClient);
		rentTO10.setRentOfficeTO(addedOffice);
		rentTO10.setRentDate(java.sql.Date.valueOf("2016-07-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-07-10"));
		rentTO10.setPrice(1000);
		RentTO savedRent10 = rentService.addRent(rentTO10);
		
		
		RentTO rentTO11 = new RentTO();
		rentTO11.setCarTO(updatedCar1);
		rentTO11.setClientTO(addedClient1);
		rentTO11.setRentOfficeTO(addedOffice);
		rentTO11.setRentDate(java.sql.Date.valueOf("2016-08-01"));
		rentTO.setReturnDate(java.sql.Date.valueOf("2016-08-10"));
		rentTO11.setPrice(1000);
		RentTO savedRent11 = rentService.addRent(rentTO11);


		// when

		Long result = rentService.countRentedCars(java.sql.Date.valueOf("2016-06-24"), java.sql.Date.valueOf("2016-06-25"));
		Long expexted = 0L;
		// then
		assertNotNull(result);
		assertEquals(expexted, result);

	}

}
