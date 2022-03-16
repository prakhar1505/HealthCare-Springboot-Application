package com.healthCare.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthCare.dao.IPatientRepository;
import com.healthCare.model.Patient;

@Service
public class IPatientServiceImpl implements IPatientService {
	
	@Autowired
	private IPatientRepository prepository;

	@Override
	public Patient registerPatient(Patient patient) {
		return prepository.registerPatient(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return prepository.updatePatient(patient);
	}

	@Override
	public Patient viewPatient(String patientName) {
		return prepository.viewPatient(patientName);
	}
	 
	public Patient getPatientById(Integer pid) {
		return prepository.getPatientById(pid);
	}

	
	
}
