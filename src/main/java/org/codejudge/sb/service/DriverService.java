package org.codejudge.sb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codejudge.sb.dto.AvailableCabs;
import org.codejudge.sb.dto.DriverRequestDto;
import org.codejudge.sb.dto.LocationRequestDto;
import org.codejudge.sb.exception.DriverAlreadyExistsException;
import org.codejudge.sb.exception.DriverNotFoundException;
import org.codejudge.sb.model.Driver;
import org.codejudge.sb.repository.DriverRepository;
import org.codejudge.sb.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
	
	private static final Logger log = LoggerFactory.getLogger(DriverService.class);
	
	@Autowired
	private DriverRepository driverRepository;
	
	public Driver createDriver(DriverRequestDto driverRequest) throws DriverAlreadyExistsException {
		Driver driver = new Driver();
		Optional<Driver> driverMobile = driverRepository.findByMobile(driverRequest.getMobile());
		Optional<Driver> driverCarNo = driverRepository.findByCarNo(driverRequest.getCarNo());
		Optional<Driver> driverLicenseNo = driverRepository.findByLicenseNo(driverRequest.getLicenseNo());
		Optional<Driver> driverEmail = driverRepository.findByEmail(driverRequest.getEmail());
		
		if(driverMobile.isPresent()) {
			throw new DriverAlreadyExistsException("Phone number already registered");
		} else if(driverCarNo.isPresent()) {
			throw new DriverAlreadyExistsException("Car number number already registered");
		}else if(driverLicenseNo.isPresent()) {
			throw new DriverAlreadyExistsException("License number already registered");
		}else if(driverEmail.isPresent()) {
			throw new DriverAlreadyExistsException("Email already registered");
		}else {
			driver.setCarNo(driverRequest.getCarNo());
			driver.setLicenseNo(driverRequest.getLicenseNo());
			driver.setName(driverRequest.getName());
			driver.setEmail(driverRequest.getEmail());
			driver.setMobile(driverRequest.getMobile());
			return driverRepository.save(driver);
		}

	}
	
	public void updateDriverLocation(LocationRequestDto locationDto, Long id) {
		Optional<Driver> driver = driverRepository.findById(id);
		if(driver.isPresent()) {
			Driver driverObj = driver.get();
			driverObj.setLongitude(locationDto.getLongitude());
			driverObj.setLatitude(locationDto.getLatitude());
			driverRepository.save(driverObj);
		}
		else {
			throw new DriverNotFoundException(String.format("No driver with id %s found", id)); 
		}
	}
	
	public List<AvailableCabs> getNearbyCabs(LocationRequestDto locationDto) {
		log.info("Fetching all cabs");
		List<Driver> drivers = driverRepository.findAll();
		List<AvailableCabs> cabs = new ArrayList<>();
		log.info("Total cabs={}",drivers.size());
		for(Driver driver: drivers ) {
			Double d = AppUtil.findDistance(locationDto.getLatitude(),locationDto.getLongitude(),
					driver.getLatitude(), driver.getLongitude());
			if(d.compareTo(new Double(4)) <= 0) {
				cabs.add(new AvailableCabs(driver.getName(),driver.getCarNo(),driver.getMobile()));
			}
		}
		return cabs;
	}
	
	public List<Driver> getAllDrivers() {
		return driverRepository.findAll();
	}
	
}
