package org.codejudge.sb.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationRequestDto {

	@NotNull(message="Latitude cannot be null")
	private Double latitude;
	
	@NotNull(message="Longitude cannot be null")
	private Double longitude;
}
