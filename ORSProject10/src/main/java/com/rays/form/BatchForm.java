package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BatchDTO;
import com.rays.dto.RoleDTO;

public class BatchForm extends BaseForm {
	
	@NotEmpty(message="Batch Code is required")
	private String batchCode;
	
	@NotEmpty(message="Batch Name is required")
	private String batchName;
	
	@NotEmpty(message="Trainer Name is required")
	private String trainerName;
	
	@NotEmpty(message="Batch Timing is required")
	private String batchTiming;
	
	
	public String getBatchCode() {
		return batchCode;
	}



	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}



	public String getBatchName() {
		return batchName;
	}



	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}



	public String getTrainerName() {
		return trainerName;
	}



	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}



	public String getBatchTiming() {
		return batchTiming;
	}



	public void setBatchTiming(String batchTiming) {
		this.batchTiming = batchTiming;
	}



	@Override
	public BaseDTO getDto() {
		BatchDTO dto=initDTO(new BatchDTO());
		dto.setBatchCode(batchCode);
		dto.setBatchName(batchName);
		dto.setTrainerName(trainerName);
		dto.setBatchTiming(batchTiming);
		return dto;
	}

}
