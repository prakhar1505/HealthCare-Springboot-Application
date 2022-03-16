package com.healthCare.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity //Specifies that class is a entity
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticTest  {
	@Id
	@GeneratedValue
	//Primary Key for Diagnostic Test
	private int testId;
	//Property of Diagnostic Test
	@ApiModelProperty(notes = "Test Name") 
	private String testName;
	//Property of Diagnostic Test
	@ApiModelProperty(notes = "Test Price")
	private double testPrice;
	//Property of Diagnostic Test
	@ApiModelProperty(notes = "Normal Value of Test")
	private String normalValue;
	//Property of Diagnostic Test
	@ApiModelProperty(notes = "Unit of Measurement")
	private String units;
	//Many to Many Relation with diagnostic center
	@ManyToMany(cascade = CascadeType.ALL,targetEntity = DiagnosticCenter.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "testId", referencedColumnName = "testId")
	private Set<DiagnosticCenter> diagnosticCenter;
}