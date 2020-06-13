package org.codejudge.sb.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CabResponse {

	@JsonProperty("available_cabs")
	private List<AvailableCabs> availableCabs;
}
