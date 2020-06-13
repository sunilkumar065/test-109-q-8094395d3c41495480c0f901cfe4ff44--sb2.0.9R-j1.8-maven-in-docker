package org.codejudge.sb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AvailableCabs {
	private String name;
	
	@JsonProperty("car_number")
	private String carNo;
	
	@JsonProperty("phone_number")
	private Long mobile;
	
	
}
