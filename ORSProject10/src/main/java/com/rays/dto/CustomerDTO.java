package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_customer")
public class CustomerDTO extends BaseDTO {
	
	@Column(name="name",length=255)
	private String name;
	
	@Column(name="email",length=255)
	private String email;
	
	@Column(name="phone_number",length=255)
	private String phoneNumber;
	
	@Column(name="address",length=255)
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
	public String getValue() {
		return name;
	}

	@Override
	public String getUniqueKey() {
		return "name";
	}

	@Override
	public String getUniqueValue() {
		return name;
	}

	@Override
	public String getLabel() {
		return "name";
	}

	@Override
	public String getTableName() {
		return "Customer";
	}
	
}
