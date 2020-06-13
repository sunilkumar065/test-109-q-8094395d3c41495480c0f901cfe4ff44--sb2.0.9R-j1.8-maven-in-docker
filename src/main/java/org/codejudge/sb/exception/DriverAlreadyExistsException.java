package org.codejudge.sb.exception;

public class DriverAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DriverAlreadyExistsException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public DriverAlreadyExistsException(String msg) {
		super(msg);
	}
}
