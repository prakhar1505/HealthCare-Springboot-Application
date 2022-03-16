package com.healthCare.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthCare.model.Patient;
import com.healthCare.service.IPatientServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/hcpc")	//hcpc = health care patient controller
@Api(value = "Patient", tags = { "Patient" }, description = "Controller for Patient")
public class PatientController {

	@Autowired
	private  IPatientServiceImpl pservice;
	
	
	//working
	@PostMapping(value = "/registerPatient")
	@ApiOperation(value = "Add patient")
	public ResponseEntity<String> registerPatient(@RequestBody Patient patient) {
		Patient pati= pservice.registerPatient(patient);
		return new ResponseEntity<String>("Patient with ID :" + pati.getPatientId()+ " created Successfully", HttpStatus.CREATED);
	}
	
	//working
	@PutMapping(value = "/updatePatient/{pid}")
	@ApiOperation(value = "update the patient by patient id")
	public ResponseEntity<Patient> updatePatient(@PathVariable int pid,@RequestBody Patient patient)
	{
		Patient patient1=pservice.getPatientById(pid);
		patient1.setAge(patient.getAge());
		patient1.setPname(patient.getPname());
		patient1.setPhoneNo(patient.getPhoneNo());
		patient1.setGender(patient.getGender());
		pservice.registerPatient(patient1);
		return new ResponseEntity<Patient>(patient1,HttpStatus.OK);
	}
	
	//working
	@GetMapping(value="/viewPatient/{patientName}")
	@ApiOperation(value = "Get patient by patient name")
	public ResponseEntity<String> viewPatient(@PathVariable String patientName)
	{
		Patient patient=pservice.viewPatient(patientName);
		return new ResponseEntity<String>("Patient id is: "+patient.getPatientId() +"\nPatient name: "+patient.getPname()+"\nPatient Age: "+patient.getAge()+"\nPatient  gender: "+patient.getGender()+"\nPatient Phone No: "+patient.getPhoneNo(),HttpStatus.OK);
	}
}