package org.codejudge.sb.controller;

import javax.validation.Valid;

import org.codejudge.sb.dto.DriverRequestDto;
import org.codejudge.sb.dto.DriverResponseDto;
import org.codejudge.sb.model.Driver;
import org.codejudge.sb.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/driver")
public class AppController {
	
	@Autowired
	private DriverService driverService;
	
    @ApiOperation("API to register a new Driver")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    private DriverResponseDto registerDriver(@RequestBody @Valid DriverRequestDto driverDto) {
    	Driver newDriver = driverService.createDriver(driverDto);
    	DriverResponseDto driverResponse = new DriverResponseDto();
    	driverResponse.setId(newDriver.getId());
    	driverResponse.setEmail(newDriver.getEmail());
    	driverResponse.setName(newDriver.getName());
    	driverResponse.setCarNo(newDriver.getCarNo());
    	driverResponse.setLicenseNo(newDriver.getLicenseNo());
    	driverResponse.setMobile(newDriver.getMobile());
    	return driverResponse;
    }

}
