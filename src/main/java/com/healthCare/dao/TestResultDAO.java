package com.healthCare.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthCare.model.Patient;
import com.healthCare.model.TestResult;

public interface TestResultDAO extends JpaRepository<TestResult, Integer>{
	//public Set<TestResult> findAllByAppointment(int appointmentId);
}
