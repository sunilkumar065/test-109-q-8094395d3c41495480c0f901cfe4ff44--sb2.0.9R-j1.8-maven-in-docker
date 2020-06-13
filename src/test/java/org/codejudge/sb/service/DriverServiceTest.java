package org.codejudge.sb.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.codejudge.sb.dto.AvailableCabs;
import org.codejudge.sb.dto.LocationRequestDto;
import org.codejudge.sb.model.Driver;
import org.codejudge.sb.repository.DriverRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverServiceTest {
	
	@InjectMocks
	private DriverService driverService;
	
	@Mock
	private DriverRepository driverRepository;
	
	List<Driver> drivers;
	
	@Before
	public void setUp() {
		drivers = new ArrayList<>();
		
		Driver d1 = new Driver();
		d1.setId(1L);
		d1.setCarNo("ABC");
		d1.setLicenseNo("XYZ");
		d1.setEmail("abc@example.com");
		d1.setMobile(7954025006L);
		d1.setName("John");
		d1.setLatitude(new Double(53.32055555555556));
		d1.setLongitude(new Double(-1.7297222222222221));
		
		Driver d2 = new Driver();
		d2.setId(2L);
		d2.setCarNo("DEF");
		d2.setLicenseNo("PQR");
		d2.setEmail("xyz@example.com");
		d2.setMobile(6761589849L);
		d2.setName("Jamie");
		d2.setLatitude(new Double(53.31861111111111));
		d2.setLongitude(new Double(-1.6997222222222223));
		
		drivers.add(d1);
		drivers.add(d2);
	}

	@Test
	public void testFindNearbyCabs() {
		when(driverRepository.findAll()).thenReturn(drivers);
		LocationRequestDto location = new LocationRequestDto();
		location.setLatitude(Double.valueOf(53.3478));
		location.setLongitude(Double.valueOf(-1.6787386472));
		List<AvailableCabs> cabs = driverService.getNearbyCabs(location);
		assertEquals(1,cabs.size());
	}

}
