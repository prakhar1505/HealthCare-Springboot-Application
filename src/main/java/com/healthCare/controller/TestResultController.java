package com.healthCare.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthCare.model.DiagnosticTest;
import com.healthCare.model.Patient;
import com.healthCare.model.TestResult;
import com.healthCare.service.ITestResultService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/hctrc")
@Api(value = "Test Result", tags = { "Test Result" },description = "Controller for Test Result")
@CrossOrigin
public class TestResultController {
	@Autowired
	private ITestResultService testResultService;

	@PostMapping("/addtestresult")
	@ApiOperation(value = "Add Test Result", response = TestResult.class)
	public ResponseEntity<TestResult> addTestResult(@RequestBody TestResult tr) {
		TestResult t = testResultService.addTestResult(tr);
		return new ResponseEntity<TestResult>(t, HttpStatus.CREATED);
	}

	@PutMapping("/updatetestresult")
	@ApiOperation(value = "Update Test Result", response = TestResult.class)
	public ResponseEntity<TestResult> updateTestResult(@RequestBody TestResult tr) {
		TestResult t = testResultService.updateTestResult(tr);
		return new ResponseEntity<TestResult>(t, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removetestresult/{testId}")
	@ApiOperation(value = "Delete Test Result", response = TestResult.class)
	public ResponseEntity<String> removeTestResult(@PathVariable int testId) {
		testResultService.removeTestResult(testId);
		return new ResponseEntity<String>("Record Removed", HttpStatus.OK);
	}

	@GetMapping("/viewResultByPatient")
	@ApiOperation(value = "View results by Patient Id", response = TestResult.class)
	public ResponseEntity<Set<TestResult>> viewResultByPatient(@RequestBody Patient patient) {
		Set<TestResult> set = testResultService.viewResultsByPatient(patient);
		return new ResponseEntity<Set<TestResult>>(set, HttpStatus.OK);
	}
	
	@GetMapping("/getalltestresult")
	@ApiOperation(value = "View all results", response = TestResult.class)
	public ResponseEntity<List<TestResult>> viewAllResult() {
		List<TestResult> list = testResultService.getAllTestResult();
		return new ResponseEntity<List<TestResult>>(list, HttpStatus.OK);
	}
}
