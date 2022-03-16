package com.healthCare.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthCare.dao.ITestResultRepository;
import com.healthCare.model.Patient;
import com.healthCare.model.TestResult;

@Service
public class ITestResultServiceImpl implements ITestResultService {

	@Autowired
	private ITestResultRepository testRep;

	// Add a new test result
	@Override
	public TestResult addTestResult(TestResult tr) {
		// TODO Auto-generated method stub
		TestResult t = testRep.addTestResult(tr);

		return t;
	}

	// Update a test result
	@Override
	public TestResult updateTestResult(TestResult tr) {
		TestResult t = testRep.updateTestResult(tr);

		return t;
	}

	// Remove a Test result
	@Override
	public TestResult removeTestResult(int testId) {
		TestResult tr = testRep.removeTestResult(testId);

		return tr;
	}

	// View test results of a particular patient
	@Override
	public Set<TestResult> viewResultsByPatient(Patient patient) {
		Set<TestResult> set = testRep.viewResultsByPatient(patient);
		return set;
	}

	@Override
	public List<TestResult> getAllTestResult() {
		// TODO Auto-generated method stub
		List<TestResult> list = testRep.getAllTestResult();
		return list;
	}

}
