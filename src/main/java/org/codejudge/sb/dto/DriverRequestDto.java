package org.codejudge.sb.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.codejudge.sb.annotation.ValidPhoneNumber;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRequestDto {

	@NotBlank
	@JsonProperty("name")
	private String name;
	
	@NotBlank
	@Email
	@JsonProperty("email")
	private String email;

	@ValidPhoneNumber
	@JsonProperty("phone_number")
	@NotNull
	private Long mobile;
	
	@NotBlank
	@JsonProperty("license_number")
	private String licenseNo;
	
	@NotBlank
	@JsonProperty("car_number")
	private String carNo;
	
}
