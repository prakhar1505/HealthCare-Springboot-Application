package com.healthCare.service;

import java.util.List;
import java.util.Set;

import com.healthCare.model.Patient;
import com.healthCare.model.TestResult;

public interface ITestResultService {
	public TestResult addTestResult(TestResult tr);

	public TestResult updateTestResult(TestResult tr);

	public TestResult removeTestResult(int id);

	public Set<TestResult> viewResultsByPatient(Patient patient);
	
	public List<TestResult> getAllTestResult();
}
