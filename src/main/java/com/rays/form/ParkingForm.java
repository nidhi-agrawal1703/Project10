package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ParkingDTO;
import com.rays.dto.RoleDTO;

public class ParkingForm extends BaseForm {
	
	@NotEmpty(message="Parking Code is required")
	private String parkingCode;
	
	@NotEmpty(message="Vehicle Number is required")
	private String vehicleNumber;
	
	@NotEmpty(message="Slot Number is required")
	private String slotNumber;
	
	@NotEmpty(message="Status is required")
	private String status;

	public String getParkingCode() {
		return parkingCode;
	}

	public void setParkingCode(String parkingCode) {
		this.parkingCode = parkingCode;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public BaseDTO getDto() {
		ParkingDTO dto=initDTO(new ParkingDTO());
		dto.setParkingCode(parkingCode);
		dto.setVehicleNumber(vehicleNumber);
		dto.setSlotNumber(slotNumber);
		dto.setStatus(status);
		return dto;
	}
}
