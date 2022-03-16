package com.healthCare.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.healthCare.dao.TestResultDAO;
import com.healthCare.model.DiagnosticTest;
import com.healthCare.model.TestResult;
import com.healthCare.service.ITestResultService;

@SpringBootTest
public class TestTestResultService {
	@MockBean
	private TestResultDAO testResRepo;
	@Autowired
	private ITestResultService testService;

	@Test
	public void testAddTestResult() {
		Optional<TestResult> testResult = Optional.ofNullable(new TestResult(1, 120.2, "normal", null));
		when(testResRepo.save(testResult.get())).thenReturn(testResult.get());
		assertEquals(testResult.get().getTestResultId(), testService.addTestResult(testResult.get()).getTestResultId());
	}

	@Test
	public void testUpdateTestResult() {
		Optional<TestResult> testResult = Optional.ofNullable(new TestResult(1, 127.2, "normal", null));
		when(testResRepo.save(testResult.get())).thenReturn(testResult.get());
		assertEquals(testResult.get().getTestReading(), testService.updateTestResult(testResult.get()).getTestReading());
	}
	

}
