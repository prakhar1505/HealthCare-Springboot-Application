package com.healthCare.dao;

import java.io.IOException;
import java.util.Optional;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthCare.exception.PatientNotFoundException;
import com.healthCare.model.Patient;

@Repository
public class IPatientRepository {
	
	static Logger log = Logger.getLogger(ITestResultRepository.class);
	static private PatternLayout patternLayout;
	private static FileAppender fileAppender;
	static {
		patternLayout = new PatternLayout("%d ## %M ##* %p ##* %m ## %L %n");
		try {
			fileAppender = new FileAppender(patternLayout, "mylogs.log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.addAppender(fileAppender);
	}
	

	@Autowired
	private PatientDAO patient;
	
	public Patient registerPatient(Patient patient1) {
		log.info("Patient added");
		return patient.save(patient1);
	}

	public Patient updatePatient(Patient patient1) {
		log.info("Patient updated");
		return patient.save(patient1);
	}

	public Patient viewPatient(String patientName) {
		Optional<Patient> optional=patient.findByName(patientName);
		Patient emp=optional.orElseThrow(()->new PatientNotFoundException("Patient Not Exists"));
		return emp;
		}
	 
	public Patient getPatientById(Integer pid) {
		Optional<Patient> optional=patient.findById(pid);
		Patient emp=optional.orElseThrow(()->new PatientNotFoundException("Patient Not Exists"));
		return emp;
	}
}
