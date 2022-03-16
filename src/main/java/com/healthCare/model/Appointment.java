package com.healthCare.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private int appointmentId;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(notes = "Appointment Date")
	@NotEmpty(message = "Please provide avilable date")
	private Date appointmentDate;
	
	@ApiModelProperty(notes = "Approval Status")
	private String approvalStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "appointment_diagnostictest", joinColumns = { @JoinColumn(name = "appointment_id") }, inverseJoinColumns = { @JoinColumn(name = "test_id")})
	@ApiModelProperty(notes = "Relation with Diagnostic Test class")
	private Set<DiagnosticTest> diagnosticTests;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id",referencedColumnName="patientId")
	@ApiModelProperty(notes = "Relation with Patient class")
	private Patient patient;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "center_id", referencedColumnName="centerId")
	@ApiModelProperty(notes = "Relation with Diagnostic center class")
	private DiagnosticCenter diagnosticCenter;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Appointment_testresult", joinColumns = { @JoinColumn(name = "appointment_id") }, inverseJoinColumns = { @JoinColumn(name = "testresult_id")})
	@ApiModelProperty(notes = "Relation with test result class")
	private Set<TestResult> testResult;
	
}