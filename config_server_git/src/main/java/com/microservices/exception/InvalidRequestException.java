package com.microservices.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;

public class InvalidRequestException extends RuntimeException {

	/**
	 * 
	 */
	private List<String> errors;
	private static final long serialVersionUID = 1L;

	public InvalidRequestException(final String message) {
		super(message);

	}

	public InvalidRequestException() {
		super();

	}

	public InvalidRequestException(BindingResult result) {
		this();
		List<String> errorsMsgs = new ArrayList<>();
		errors = new ArrayList<>();
		result.getAllErrors()
				.forEach(m -> errorsMsgs.add(m.getDefaultMessage()));
		errors.addAll(errorsMsgs);
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
