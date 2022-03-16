package com.healthCare.service;

import com.healthCare.model.Patient;

public interface IPatientService {

	public Patient registerPatient(Patient patient);
	
	public Patient updatePatient(Patient patient);
	
	public Patient viewPatient(String patientName);
	
}