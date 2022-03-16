package com.healthCare.service;
import java.util.List;

import com.healthCare.model.Appointment;
import com.healthCare.model.DiagnosticCenter;
import com.healthCare.model.DiagnosticTest;

public interface IDiagnosticCenter {

	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId);
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public DiagnosticTest viewTestDetails(int diagnosticCenterId,String testName);
	public DiagnosticTest addTest(int diagnosticcenterId,int testId);
	public DiagnosticCenter getDiagnosticCenter(String centername);
	public DiagnosticCenter removeDiagnosticCenter(int id);
	
	
}
