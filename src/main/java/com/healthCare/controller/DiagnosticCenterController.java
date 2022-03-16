package com.healthCare.controller;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthCare.model.DiagnosticCenter;
import com.healthCare.model.DiagnosticTest;
import com.healthCare.service.IDiagnosticCenter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/hcdcc")  //hcdcc:heatlh care diagnostic center controller


@Api(value = "Diagnostic Center", tags = { "Diagnostic Center" })


public class DiagnosticCenterController {
	@Autowired
	private IDiagnosticCenter icenter;

	// to get list of all Diagnostic Center
	@GetMapping("/centers")
	@ApiOperation(value = "List all the Centers available", response = DiagnosticCenter.class)
	public List<DiagnosticCenter> getAllDiagnosticCenters(){
		List<DiagnosticCenter> list= icenter.getAllDiagnosticCenters();
		return list;
	}

	//to add Diagnostic Center
	@PostMapping("/centers")
	@ApiOperation(value = "Add Diagnostic Center", response = DiagnosticCenter.class)
	public ResponseEntity<DiagnosticCenter> addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {
		DiagnosticCenter center = icenter.addDiagnosticCenter(diagnosticCenter);
		return new ResponseEntity<DiagnosticCenter>(center, HttpStatus.ACCEPTED);

	}

	//to get Diagnostic Center of particular Id.
	@GetMapping("/centers/{diagnosticCenterId}")
	@ApiOperation(value = "Center of particular CenterId", response = DiagnosticCenter.class)
	public ResponseEntity<DiagnosticCenter> getDiagnosticCenterById(@PathVariable int diagnosticCenterId)
	{
		DiagnosticCenter centerId=icenter.getDiagnosticCenterById(diagnosticCenterId);
		return new ResponseEntity<DiagnosticCenter>(centerId,HttpStatus.OK);
	}

	//to update Diagnostic Center
	@PutMapping("/centers")
	@ApiOperation(value = "Update Center", response = DiagnosticCenter.class)
	public ResponseEntity<DiagnosticCenter> updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticcenter) {
		DiagnosticCenter updateCenter = icenter.updateDiagnosticCenter(diagnosticcenter);
		return new ResponseEntity<DiagnosticCenter>(updateCenter, HttpStatus.OK);
	}

	//to view test Details
	@GetMapping("/viewtest/{diagnosticCenterId}")
	@ApiOperation(value = "View details of a test from a center", response = DiagnosticCenter.class)//check response
	public ResponseEntity<DiagnosticTest>viewTestDetails (@PathVariable int diagnosticCenterId,@RequestBody String testName){
		DiagnosticTest viewTest=icenter.viewTestDetails(diagnosticCenterId, testName);
		return  new ResponseEntity<DiagnosticTest>(viewTest,HttpStatus.OK);
	}

	//to add test 
	@PostMapping("/addtest/{diagnosticCenterId}")
	public ResponseEntity<String>addTest (@PathVariable int diagnosticCenterId,@RequestBody int testId){
		icenter.addTest(diagnosticCenterId,testId);
		return new ResponseEntity<String>("Test With ID :" + testId + " added Successfully", HttpStatus.CREATED);

	}

	//to get Diagnostic Center by name
	@GetMapping("getcentername/{centername}")
	public ResponseEntity<DiagnosticCenter> getDiagnosticCenter(@PathVariable String centername){
		DiagnosticCenter centerName=icenter.getDiagnosticCenter(centername);
		return new ResponseEntity<DiagnosticCenter>(centerName,HttpStatus.OK);
	}

	//to delete Diagnostic Center of particular id
	@DeleteMapping(value =  "/centers/{centerId}")
	@ApiOperation(value = "Remove a center", response = DiagnosticCenter.class)
	public ResponseEntity<String> removeDiagnosticCenter(@PathVariable Integer centerId){
		icenter.removeDiagnosticCenter(centerId);
		return new ResponseEntity<String>("Diagnostic Center With ID :" + centerId + " Deleted Successfully", HttpStatus.OK);
	}

	
	
	
}