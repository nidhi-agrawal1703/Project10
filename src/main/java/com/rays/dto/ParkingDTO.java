package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_parking")
public class ParkingDTO extends BaseDTO {
	
	@Column(name="parking_code",length=255)
	private String parkingCode;
	
	@Column(name="vehicle_number",length=255)
	private String vehicleNumber;
	
	@Column(name="slot_number",length=255)
	private String slotNumber;
	
	@Column(name="status",length=255)
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
	public String getValue() {
		return parkingCode;
	}

	@Override
	public String getUniqueKey() {
		return "parkingCode";
	}

	@Override
	public String getUniqueValue() {
		return parkingCode;
	}

	@Override
	public String getLabel() {
		return "Parking Code";
	}

	@Override
	public String getTableName() {
		return "Parking";
	}

}
