package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_batch")
public class BatchDTO extends BaseDTO {
	
	@Column(name="batch_code",length=255)
	private String batchCode;
	
	@Column(name="batch_name",length=255)
	private String batchName;
	
	@Column(name="trainer_name",length=255)
	private String trainerName;
	
	@Column(name="batch_timing",length=255)
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
	public String getValue() {
		return batchCode;
	}
	@Override
	public String getUniqueKey() {
		return "batchCode";
	}
	@Override
	public String getUniqueValue() {
		return batchCode;
	}
	@Override
	public String getLabel() {
		return "Batch Code";
	}
	@Override
	public String getTableName() {
		return "Batch";
	}
	
	
	
}
