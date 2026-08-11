package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CustomerDTO;

public class CustomerForm extends BaseForm {
	
	@NotEmpty(message="Name is required")
	private String name;
	
	@NotEmpty(message="Email is required")
	private String email;
	
	@NotEmpty(message="Phone Number is required")
	private String phoneNumber;
	
	@NotEmpty(message="Address is required")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public BaseDTO getDto() {
		
		CustomerDTO dto=initDTO(new CustomerDTO());
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhoneNumber(phoneNumber);
		dto.setAddress(address);
		return dto;
	}
}
