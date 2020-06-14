package org.codejudge.sb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
	
	private String status = "failure";
	private String reason;
	
	public ApiError(String reason) {
		this.reason = reason;
	}
}
