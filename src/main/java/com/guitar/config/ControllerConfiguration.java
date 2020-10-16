package com.guitar.config;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerConfiguration {
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid data sent to server.")
	public void notValid() {
		//If needed, you can send the error message to an email address 
		//or perform whatever other actions are needed to deal with the error.
	}
	
	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="New manufacturer must be active.")
	public void inactiveManufacturerCreated() {
		//This method returns a more clear message.
	}
}
