package com.healthCare.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	@ApiModelProperty(notes = "patient name")
	@NotEmpty(message = "Please provide patient name")
	private String pname;
	@ApiModelProperty(notes = "patient number")
	@NotEmpty(message = "Please provide patient number")
	private String phoneNo;
	@ApiModelProperty(notes = "patient age")
	@NotNull(message = "Please provide age")
	private int age;
	@ApiModelProperty(notes = "patient gender")
	@NotEmpty(message = "Please provide gender")
	private String gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	@ApiModelProperty(notes = "Relation with Appointment class")
	private Set<Appointment> appointment;	
}