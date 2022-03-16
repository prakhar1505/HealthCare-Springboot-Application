package com.healthCare.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthCare.dao.IDiagnosticTestRepository;
import com.healthCare.model.DiagnosticTest;

@Service //Describe that the class is a service
public class IDiagnosticTestServiceImpl implements IDiagnosticTestService {
	
	@Autowired
	private IDiagnosticTestRepository diagnosticRep;
	
	//Add a new Diagnostic Test
	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test) {
		DiagnosticTest dig= diagnosticRep.addNewTest(test);
		return dig;
	}
	
	//Get all the tests
	@Override
	public List<DiagnosticTest> getAllTest() {
		List<DiagnosticTest> list=diagnosticRep.getAllTest();
		return list;
	}
	//Get all tests in a particular center
	@Override
	public Set<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) {
		Set<DiagnosticTest> list=diagnosticRep.getTestsOfDiagnosticCenter(centerId);
		return list;
	}
	//Remove test from a diagnostic center
	@Override
	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) {
		DiagnosticTest dig=diagnosticRep.removeTestFromDiagnosticCenter(centerId, test);
		return dig;
	}
	//Update Details of a Diagnostic Test
	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test) {
		DiagnosticTest dig = diagnosticRep.updateTestDetail(test);
		return dig;
	}

	@Override
	public String removeDiagnosticTest(int testId) {
		// TODO Auto-generated method stub
		String str=diagnosticRep.removeDiagnosticTest(testId);
		return str;
	}

}
