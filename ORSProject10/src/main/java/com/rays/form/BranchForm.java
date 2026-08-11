package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BatchDTO;
import com.rays.dto.BranchDTO;

public class BranchForm extends BaseForm{

	@NotEmpty(message="Branch Name is required")
	private String branchName;
	
	@NotEmpty(message="City is required")
	private String city;
	
	@NotEmpty(message="Manager Name is required")
	private String managerName;
	
	@NotEmpty(message="Contact No is required")
	private String contactNo;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@Override
	public BaseDTO getDto() {
		BranchDTO dto=initDTO(new BranchDTO());
		dto.setBranchName(branchName);
		dto.setCity(city);
		dto.setManagerName(managerName);
		dto.setContactNo(contactNo);
		return dto;
	}
}
