package com.microservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.microservices.exception.InvalidRequestException;

/**
 * This class will extract the error details from InvalidRequestException and
 * convert it into VndErrors and return it as 'HTTP 400 Bad Request' as
 * response.
 *
 */
@ControllerAdvice
public class SearchControllerAdvice {

	@ResponseBody
	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String searchControllerInternalServerErrorHandler(final InvalidRequestException exception) {
		String message = "";
		if (!CollectionUtils.isEmpty(exception.getErrors())) {
			message = exception.getErrors().toString();
		}
		System.out.println("Errors : " + message);
		return message;
	}

}
