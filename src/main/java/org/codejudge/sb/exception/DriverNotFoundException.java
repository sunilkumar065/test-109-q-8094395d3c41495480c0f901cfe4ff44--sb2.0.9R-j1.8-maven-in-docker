package org.codejudge.sb.exception;

public class DriverNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DriverNotFoundException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public DriverNotFoundException(String msg) {
		super(msg);
	}
}
