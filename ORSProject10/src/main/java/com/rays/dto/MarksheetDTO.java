package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_marksheet")
public class MarksheetDTO extends BaseDTO{
	
	@Column(name="roll_no",length=50)
	protected String rollNo;
	
	@Column(name="student_id")
	protected long studentId;
	
	@Column(name="name",length=100)
	protected String name;
	
	@Column(name="physics")
	protected Integer physics;
	
	@Column(name="chemistry")
	protected Integer chemistry;
	
	@Column(name="maths")
	protected Integer maths;

	@Override
	public String getUniqueKey() {
		return "rollNo";
	}

	@Override
	public String getUniqueValue() {
		return rollNo;
	}

	@Override
	public String getLabel() {
		return "Roll No";
	}

	@Override
	public String getTableName() {
		return "Marksheet";
	}

	@Override
	public String getValue() {
		return name;
	}
}
