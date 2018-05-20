package com.microservices.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.exception.InvalidRequestException;
import com.microservices.request.EmployeeRequest;
import com.microservices.response.EmployeeResponse;

@RestController
/**
 * In Spring’s approach to building RESTful web services, HTTP requests are
 * handled by a controller. These components are easily identified by
 * the @RestController annotation
 * 
 */
@RequestMapping("/")
public class MainController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public EmployeeResponse getEmployee(@Valid final EmployeeRequest request, final BindingResult validationResult) {
		validate(validationResult);
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, EmployeeResponse.class);

	}

	@RequestMapping(value = "/employee1", method = RequestMethod.GET)
	public EmployeeResponse getEmployee1() {
		return null;

	}

	private void validate(final BindingResult validationResult) {
		if (validationResult.hasErrors()) {
			throw new InvalidRequestException(validationResult);
		}
	}
}
