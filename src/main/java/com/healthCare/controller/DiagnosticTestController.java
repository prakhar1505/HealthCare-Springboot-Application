package com.healthCare.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthCare.model.DiagnosticTest;
import com.healthCare.service.IDiagnosticTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/hcdtc")
@Api(value = "Dianostic Test", tags = { "Diagnostic Test" }, description = "Controller for Diagnostic Test")
@CrossOrigin
public class DiagnosticTestController {
	@Autowired
	private IDiagnosticTestService digServices;

	@GetMapping("/getAllDiagnosticTest")
	@ApiOperation(value = "Get all the Diagnostic Tests")
	public ResponseEntity<List<DiagnosticTest>> getAllTest() {
		List<DiagnosticTest> list = digServices.getAllTest();
		return new ResponseEntity<List<DiagnosticTest>>(list, HttpStatus.OK);
	}

	@GetMapping("/TestsOfDiagnosticCenters/{centerId}")
	@ApiOperation(value = "Get test of a Diagnostic Center")
	public ResponseEntity<Set<DiagnosticTest>> getTestsOfDiagnosticCenter(@PathVariable int centerId) {
		Set<DiagnosticTest> list = digServices.getTestsOfDiagnosticCenter(centerId);
		return new ResponseEntity<Set<DiagnosticTest>>(list, HttpStatus.OK);
	}

	@PostMapping("/addTest")
	@ApiOperation(value = "Add a Test")
	public ResponseEntity<DiagnosticTest> addNewTest(@RequestBody DiagnosticTest test) {
		DiagnosticTest dig = digServices.addNewTest(test);
		return new ResponseEntity<DiagnosticTest>(dig, HttpStatus.ACCEPTED);
	}

	@PutMapping("/UpdateTest")
	@ApiOperation(value = "Update a Test")
	public ResponseEntity<DiagnosticTest> updateTestDetail(@RequestBody DiagnosticTest test) {
		DiagnosticTest dig = digServices.updateTestDetail(test);
		return new ResponseEntity<DiagnosticTest>(dig, HttpStatus.OK);
	}

	@DeleteMapping("/RemoveTestFromCenter/{centerId}")
	@ApiOperation(value = "Remove a Test from Diagnostic Center")
	public ResponseEntity<DiagnosticTest> removeTestFromDiagnosticCenter(@PathVariable int centerId,
			@RequestBody DiagnosticTest test) {
		DiagnosticTest dig = digServices.removeTestFromDiagnosticCenter(centerId, test);
		return new ResponseEntity<DiagnosticTest>(dig, HttpStatus.OK);
	}
	@DeleteMapping("/RemoveTest/{testId}")
	@ApiOperation(value = "Remove a Test")
	public ResponseEntity<String> removeDiagnosticTest(@PathVariable int testId) {
		String dig = digServices.removeDiagnosticTest(testId);
		return new ResponseEntity<String>(dig, HttpStatus.OK);
	}
}
