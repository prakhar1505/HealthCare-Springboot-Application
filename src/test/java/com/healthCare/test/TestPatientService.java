package com.healthCare.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.healthCare.service.IPatientService;

@SpringBootTest
public class TestPatientService {

	@Autowired
	private IPatientService patientService;
}
