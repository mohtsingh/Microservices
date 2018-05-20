package com.microservices.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeRequest {

	@Min(value=0,message="id minimum value should be 1")
	private int id;
	@NotEmpty(message="name cannot be empty")
	private String name;
	private String city;
	
	public EmployeeRequest(@NotNull int id, @NotEmpty String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
}
