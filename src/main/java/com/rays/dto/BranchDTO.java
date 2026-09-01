package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_branch")
public class BranchDTO extends BaseDTO {
	
	@Column(name="branch_name",length=255)
	private String branchName;
	
	@Column(name="city",length=255)
	private String city;
	
	@Column(name="manager_name",length=255)
	private String managerName;
	
	@Column(name="contact_no",length=255)
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
	public String getValue() {
		return branchName;
	}

	@Override
	public String getUniqueKey() {
		return "branchName";
	}

	@Override
	public String getUniqueValue() {
		return branchName;
	}

	@Override
	public String getLabel() {
		return "Branch Name";
	}

	@Override
	public String getTableName() {
		return "branch";
	}

}
