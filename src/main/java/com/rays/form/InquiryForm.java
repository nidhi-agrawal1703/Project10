package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InquiryDTO;
import com.rays.dto.RoleDTO;

public class InquiryForm extends BaseForm{
	
	@NotEmpty(message="Name is required")
	private String name;
	
	@NotEmpty(message="Email is required")
	private String email;
	
	@NotEmpty(message="Subject is required")
	private String subject;
	
	@NotEmpty(message="Status is required")
	private String status;
		
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		InquiryDTO dto=initDTO(new InquiryDTO());
		dto.setName(name);
		dto.setEmail(email);
		dto.setSubject(subject);
		dto.setStatus(status);
		return dto;
	}
}
