package com.healthCare.service;


import java.io.IOException;
import java.util.List;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healthCare.dao.IDiagnosticCenterRepository;
import com.healthCare.model.DiagnosticCenter;
import com.healthCare.model.DiagnosticTest;

@Service
public class IDiagnosticCenterServiceImpl implements IDiagnosticCenter {
	static Logger log = Logger.getLogger(IUserServiceImpl.class);
	static private PatternLayout patternLayout;
	private static FileAppender fileAppender;
	static {
		patternLayout = new PatternLayout("%d ## %M ##* %p ##* %m ## %L ");
		try {
			fileAppender = new FileAppender(patternLayout, "mylogs.log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.addAppender(fileAppender);
	}
	
	@Autowired
	private IDiagnosticCenterRepository centerDao;

	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		List<DiagnosticCenter> centerList=centerDao.getAllDiagnosticCenter();
		return centerList;
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		DiagnosticCenter  addCenter= centerDao.addDiagnosticCenter(diagnosticCenter);
		log.info("Center Added");
		return addCenter;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) {
		DiagnosticCenter diag=centerDao.getDiagnosticCenterById(diagnosticCenterId);
		return diag;
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		DiagnosticCenter updateCenter=centerDao.updateDiagnosticCenter(diagnosticCenter);
		log.info("Center Updated");
		return updateCenter;
	}

	@Override
	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		DiagnosticTest view_test=centerDao.viewTestDetails(diagnosticCenterId,testName);
		return view_test;
	}

	@Override
	public DiagnosticTest addTest(int diagnosticcenterId, int testId) {
		DiagnosticTest diag_test = centerDao.addTest(diagnosticcenterId,testId);
		log.info("Test Added");
	return diag_test;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenter(String centername) {
		DiagnosticCenter centerName=centerDao.getDiagnosticCenter(centername);
		return centerName;

	}

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) {
		DiagnosticCenter centerId= centerDao.removeDiagnosticCenter(id);
		log.info("Center Removed");
		return centerId;
	}
}