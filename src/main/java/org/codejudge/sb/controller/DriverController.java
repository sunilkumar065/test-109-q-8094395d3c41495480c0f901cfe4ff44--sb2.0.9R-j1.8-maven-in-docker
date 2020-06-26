package org.codejudge.sb.controller;

import java.util.List;

import javax.validation.Valid;

import org.codejudge.sb.dto.AvailableCabs;
import org.codejudge.sb.dto.CabResponse;
import org.codejudge.sb.dto.DriverRequestDto;
import org.codejudge.sb.dto.DriverResponseDto;
import org.codejudge.sb.dto.LocationRequestDto;
import org.codejudge.sb.dto.NoCabResponse;
import org.codejudge.sb.dto.SuccessResponse;
import org.codejudge.sb.model.Driver;
import org.codejudge.sb.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class DriverController {
	
	private static final Logger log = LoggerFactory.getLogger(DriverController.class);
	
	@Autowired
	private DriverService driverService;
	
    @ApiOperation("Register a new driver")
    @PostMapping("/driver/register/")
    @ResponseStatus(HttpStatus.CREATED)
    public DriverResponseDto registerDriver(@RequestBody @Validated DriverRequestDto driverDto) {
    	log.info("New driver registration started");
    	Driver newDriver = driverService.createDriver(driverDto);
    	log.info("Driver created with id={}", newDriver.getId());
    	DriverResponseDto driverResponse = new DriverResponseDto();
    	driverResponse.setId(newDriver.getId());
    	driverResponse.setEmail(newDriver.getEmail());
    	driverResponse.setName(newDriver.getName());
    	driverResponse.setCarNo(newDriver.getCarNo());
    	driverResponse.setLicenseNo(newDriver.getLicenseNo());
    	driverResponse.setMobile(newDriver.getMobile());
    	return driverResponse;
    }
    
    @ApiOperation("Update the location of driver with id")
    @PostMapping("/driver/{id}/sendLocation/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SuccessResponse updateDriverLocation(@RequestBody @Valid LocationRequestDto locationRequest, @PathVariable Long id) {
    	log.info("Updating driver cab location");
    	driverService.updateDriverLocation(locationRequest, id);
    	SuccessResponse response = new SuccessResponse();
    	response.setStatus("success");
    	return response;
    }

    @ApiOperation("Get all cabs within a radius of 4 KM")
    @PostMapping("/passenger/available_cabs/")
    public ResponseEntity<?> getAvailableCabs(@RequestBody @Valid LocationRequestDto locationRequest) {
    	List<AvailableCabs> cabs = driverService.getNearbyCabs(locationRequest);
    	if(cabs.isEmpty()) {
    		log.info("No cabs found");
    		return new ResponseEntity<>(new NoCabResponse("No cabs available!"),HttpStatus.OK);
    	}
    	CabResponse cabResponse = new CabResponse();
    	cabResponse.setAvailableCabs(cabs);
    	log.info("No of cabs found near by={}",cabs.size());
    	return new ResponseEntity<>(cabResponse,HttpStatus.OK);
    }
    
    @ApiOperation("Get all drivers")
    @GetMapping("drivers/")
    public List<Driver> getAllDrivers() {
    	return driverService.getAllDrivers();
    }
}
