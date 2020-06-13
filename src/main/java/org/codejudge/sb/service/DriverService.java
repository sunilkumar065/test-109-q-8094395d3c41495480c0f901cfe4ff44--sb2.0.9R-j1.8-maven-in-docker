package org.codejudge.sb.service;

import org.codejudge.sb.dto.DriverRequestDto;
import org.codejudge.sb.model.Driver;
import org.codejudge.sb.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepository;
	
	public Driver createDriver(DriverRequestDto driverRequest) {
		Driver driver = new Driver();
		driver.setCarNo(driverRequest.getCarNo());
		driver.setLicenseNo(driverRequest.getLicenseNo());
		driver.setName(driverRequest.getName());
		driver.setEmail(driverRequest.getEmail());
		driver.setMobile(driverRequest.getMobile());
		return driverRepository.save(driver);
	}
}
