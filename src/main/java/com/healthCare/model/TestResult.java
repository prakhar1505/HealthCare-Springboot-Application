package com.healthCare.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Specifies that class is a entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResult {
	@Id
	@GeneratedValue
	//Primary Key for Test Result
	private int testResultId;
	//Property of Test Result
	@ApiModelProperty(notes = "Test Reading")
	private double testReading;
	//Property of Test Result
	@ApiModelProperty(notes = "Condition")
	private String condition;
	
	//Many to one relation with appointment
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="appointment_id", referencedColumnName = "appointment_id")
	private Appointment appointment;
	

}
