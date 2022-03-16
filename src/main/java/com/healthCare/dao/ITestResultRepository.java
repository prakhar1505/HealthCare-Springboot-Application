package com.healthCare.dao;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthCare.exception.TestResultNotFoundException;
import com.healthCare.model.Appointment;
import com.healthCare.model.Patient;
import com.healthCare.model.TestResult;

@Repository
public class ITestResultRepository {
	
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
	public TestResultDAO testResultDao;
	@Autowired
	public PatientDAO patientDao;

	public TestResult addTestResult(TestResult tr) {
		TestResult t = testResultDao.save(tr);
		log.info("Test Result Added");
		return t;
	}

	public TestResult updateTestResult(TestResult tr) {
		TestResult t = testResultDao.save(tr);
		log.info("Test Result Added");
		return t;
	}
	
	public List<TestResult> getAllTestResult(){
		List<TestResult> list = testResultDao.findAll();
		return list;
	}

	public TestResult removeTestResult(int id) {
		Optional<TestResult> op = testResultDao.findById(id);

		TestResult tr = (TestResult) op
				.orElseThrow(() -> new TestResultNotFoundException("Test Result Does Not Exists"));
		log.info("Test Result Added");
		testResultDao.delete(tr);
		return tr;
	}

	public Set<TestResult> viewResultsByPatient(Patient patient) {
		Set<TestResult> mergedSet = new HashSet<>();
		Set<Appointment> appointmentSet = patient.getAppointment();
		for (Appointment app : appointmentSet) {
			mergedSet.addAll(app.getTestResult());
		}
		return mergedSet;
	}
}
