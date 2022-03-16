package com.healthCare.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.healthCare.model.DiagnosticTest;

public interface IDiagnosticTestService {
	public List<DiagnosticTest> getAllTest();

	public DiagnosticTest addNewTest(DiagnosticTest test);

	public Set<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId);

	public DiagnosticTest updateTestDetail(DiagnosticTest test);
	
	

	public String removeDiagnosticTest(int testId);

	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test);
}




