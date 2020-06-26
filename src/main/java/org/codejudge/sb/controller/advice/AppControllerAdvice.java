package org.codejudge.sb.controller.advice;

import org.codejudge.sb.exception.ApiError;
import org.codejudge.sb.exception.DriverAlreadyExistsException;
import org.codejudge.sb.exception.DriverNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({DriverAlreadyExistsException.class})
	public ResponseEntity<Object> handleConstraintViolation(DriverAlreadyExistsException ex, WebRequest webRequest) {
		ApiError apiError = new ApiError(ex.getLocalizedMessage());
		return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ApiError apiError = new ApiError(ex.getMessage());
		return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
				HttpStatus httpStatus, WebRequest webRequest) {
		StringBuilder sb = new StringBuilder();
		ex.getBindingResult().getFieldErrors().stream().forEach(error ->  {
			sb.append(error.getDefaultMessage());
			sb.append(" \n");
		});
		ApiError apiError = new ApiError(sb.toString());
		return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({DriverNotFoundException.class})
	public ResponseEntity<Object> handleNotFoundException(DriverNotFoundException ex, WebRequest webRequest) {
		ApiError error = new ApiError(ex.getLocalizedMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
