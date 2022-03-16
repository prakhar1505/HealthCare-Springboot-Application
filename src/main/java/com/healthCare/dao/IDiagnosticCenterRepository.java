package com.healthCare.dao;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthCare.exception.CenterNotFoundException;
import com.healthCare.model.DiagnosticCenter;
import com.healthCare.model.DiagnosticTest;


@Repository
public class IDiagnosticCenterRepository {
	@Autowired
	private DiagnosticCenterDAO diagCenterDao;
	@Autowired
	private DiagnosticTestDAO diagTestDao;

	public List<DiagnosticCenter> getAllDiagnosticCenter() {
		List<DiagnosticCenter> centerList = diagCenterDao.findAll();
		return centerList;
	}


	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		DiagnosticCenter diag = diagCenterDao.save(diagnosticCenter);
		return diag;
	}


	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) {
		Optional<DiagnosticCenter> optional=diagCenterDao.findById(diagnosticCenterId);
		DiagnosticCenter diag=optional.orElseThrow(()->new CenterNotFoundException("Center Not Exists"));
		return diag;
	}

	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		DiagnosticCenter updateCenter = diagCenterDao.save(diagnosticCenter);
		return updateCenter;
	}



	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		Optional<DiagnosticCenter> option=diagCenterDao.findById(diagnosticCenterId);
		DiagnosticCenter dc=option.get();
		Set<DiagnosticTest> set=dc.getTests();
		for(DiagnosticTest test:set) {
			if(test.getTestName().equals(testName)) {
				return test;
			}
		}
		return null;
	}

	public DiagnosticTest addTest(int diagnosticcenterId, int testId) {
		Optional<DiagnosticCenter> optionalDc=diagCenterDao.findById(diagnosticcenterId);
		Optional<DiagnosticTest> optionalDt=diagTestDao.findById(testId);
		DiagnosticCenter dc=optionalDc.get();
		DiagnosticTest dt=optionalDt.get();
		Set<DiagnosticTest> set=dc.getTests();
		set.add(dt);
		dc.setTests(set);
		diagCenterDao.save(dc);
		return dt;

	}

	public DiagnosticCenter getDiagnosticCenter(String centername) {
		Optional<DiagnosticCenter> optional=diagCenterDao.findByName(centername);
		DiagnosticCenter centerName=optional.orElseThrow(()->new CenterNotFoundException("Center Not Exists"));
		return centerName;

	}

	public DiagnosticCenter removeDiagnosticCenter(int id) {
		Optional<DiagnosticCenter> op=diagCenterDao.findById(id);
		DiagnosticCenter dc= (DiagnosticCenter) op.orElseThrow(()-> new CenterNotFoundException("Center Does Not Exists"));
		diagCenterDao.delete(dc);
		return dc;

	}

}


		


	



	
	