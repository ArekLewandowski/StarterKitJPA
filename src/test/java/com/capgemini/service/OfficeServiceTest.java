package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.EmployeeDAO;
import com.capgemini.dao.OfficeDAO;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.types.AuthorTO;
import com.capgemini.types.BookTO;
import com.capgemini.types.AuthorTO.AuthorTOBuilder;
import com.capgemini.types.BookTO.BookTOBuilder;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.OfficeTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeServiceTest {
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Test
	public void testShouldAddOffice() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		

		// when
		OfficeTO selectedOffice = officeService.getOffice(1L);

		// then
		assertNotNull(selectedOffice);
		assertEquals(addedOffice.getCity(), selectedOffice.getCity());
	}
	
	@Test
	public void testShouldAddOffices() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		

		// when
		OfficeTO selectedOffice2 = officeService.getOffice(2L);
		OfficeTO selectedOffice3 = officeService.getOffice(3L);
		OfficeTO selectedOffice4 = officeService.getOffice(4L);

		// then
		assertNotNull(selectedOffice2);
		assertNotNull(selectedOffice3);
		assertNotNull(selectedOffice4);
		assertEquals(addedOffice2.getCity(), selectedOffice2.getCity());
		assertEquals(addedOffice3.getCity(), selectedOffice3.getCity());
		assertEquals(addedOffice4.getCity(), selectedOffice4.getCity());
	}
	
	@Test
	public void testShouldDeleteOffice() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		

		// when
		officeService.deleteOffice(officeTO);
		


		// then
		assertEquals(officeService.getAllOffices().size(), 3);

	}
	
	@Test
	public void testShouldUpdateOffices() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		officeTO.setCity("Gdansk");

		// when
		OfficeTO updatedOffice = officeService.updateOffice(officeTO);
		OfficeTO selectedOffice = officeService.getOffice(1L);

		// then
		assertNotNull(selectedOffice);
		assertEquals(updatedOffice.getCity(), selectedOffice.getCity());
		assertEquals(updatedOffice.getCity(), "Gdansk");
	}

	@Test
	public void testShouldAddEmployee() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		EmployeeEntity ee1 = employeeDAO.save(new EmployeeEntity(null, "firstName", "lastName", "position", 22, null, null, null, null));
		EmployeeEntity ee2 = employeeDAO.save(new EmployeeEntity(null, "firstName2", "lastName2", "position", 32, null, null, null, null));

		// when
		officeService.addEmployeeToOffice(officeTO, EmployeeMapper.map2TO(ee1));
		Set<EmployeeTO> employies = officeService.getAllOfficeEmployies(officeTO);

		// then
		assertNotNull(employies);
		assertEquals(employies.size(), 1);
	}
	
}

