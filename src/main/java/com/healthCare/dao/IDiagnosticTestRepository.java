package com.healthCare.dao;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthCare.exception.CenterNotFoundException;
import com.healthCare.model.DiagnosticCenter;
import com.healthCare.model.DiagnosticTest;

@Repository
public class IDiagnosticTestRepository {
	
	
	static Logger log = Logger.getLogger(IDiagnosticTestRepository.class);
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
	private DiagnosticTestDAO digTestDao;
	@Autowired
	private DiagnosticCenterDAO digCenterDao;

	public List<DiagnosticTest> getAllTest() {
		List<DiagnosticTest> ls = digTestDao.findAll();
		return ls;
	}

	public DiagnosticTest addNewTest(DiagnosticTest test) {
		DiagnosticTest dig = digTestDao.save(test);
		log.info("Test Added");
		return dig;
	}

	public Set<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) {
		Optional<DiagnosticCenter> optional = digCenterDao.findById(centerId);
		DiagnosticCenter dc = null;
		try {
			dc = optional.get();
		} catch (NoSuchElementException e) {
			log.error("No center of given centerId");
			throw new CenterNotFoundException("Center not found in Diagnostic Tests");
		}
		Set<DiagnosticTest> list = digTestDao.findAllByDiagnosticCenter(dc);
		//Set<DiagnosticTest> list = dc.getTests();
		return list;
	}

	public DiagnosticTest updateTestDetail(DiagnosticTest test) {
		DiagnosticTest dig = digTestDao.save(test);
		log.info("Test Updated");
		return dig;
	}

	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) {
		Optional<DiagnosticCenter> optional = digCenterDao.findById(centerId);
		DiagnosticCenter dc = null;
		try {
			dc = optional.get();
		} catch (NoSuchElementException e) {
			log.error("No center of given centerId");
			throw new CenterNotFoundException("No center exists with this centerId");
		}
		Set<DiagnosticTest> set = dc.getTests();
		set.remove(test);
		dc.setTests(set);
		DiagnosticCenter d = digCenterDao.save(dc);
		log.info("Test removed from Diagnostic Center");
		return test;
	}
	public String removeDiagnosticTest(int testId) {
		digTestDao.deleteById(testId);
		return "Deleted Succesfully";
		
	}
}