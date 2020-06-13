package org.codejudge.sb.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationRequestDto {

	@NotBlank
	private Double latitude;
	
	@NotBlank
	private Double longitude;
}
