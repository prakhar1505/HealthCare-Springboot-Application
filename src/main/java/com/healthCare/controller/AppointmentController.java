package com.healthCare.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthCare.model.Appointment;
import com.healthCare.service.IAppointmentServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/hcac")	//hcac = health care appointment controller
@Api(value = "Appointment", tags = { "Appointment" }, description = "Controller for Appointment")
@CrossOrigin
public class AppointmentController{

	@Autowired
	private  IAppointmentServiceImpl aservice;
		
	//working
	@PostMapping(value = "/addAppointment")
	@ApiOperation(value = "Add Appointment")
	public ResponseEntity<String> addAppointment(@RequestBody Appointment appo) {
		Appointment appo1= aservice.addAppointment(appo);
		return new ResponseEntity<String>("Appointment with ID :" + appo1.getAppointmentId()+ " created Successfully", HttpStatus.CREATED);
	}
	
	//working
	@GetMapping(value="/viewAppointments/{patientName}")
	@ApiOperation(value = "Get all the appointment by patient name")
	public ResponseEntity<List<Appointment>> viewAppointments(@PathVariable String patientName)
	{
		List<Appointment> appo=aservice.viewAppointments(patientName);
		return new ResponseEntity<List<Appointment>>(appo,HttpStatus.OK);
	}

	
	//working
	@GetMapping(value="/viewAppointment/{patientId}")
	@ApiOperation(value = "Get all the appointment by patient id")
	public ResponseEntity<Appointment> viewAppointment(@PathVariable int patientId)
	{
		Appointment appo=aservice.viewAppointment(patientId);
		return new ResponseEntity<Appointment>(appo,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAppointmentList/{appointmentDate}/{approvalStatus}")
	@ApiOperation(value = "Get all the appointment on bases of Appointment Date and Approval Status")
	public ResponseEntity<List<Appointment>> getAppointmentList(@PathVariable("appointmentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date appointmentDate, @PathVariable String approvalStatus)
	{
		List<Appointment> appo=aservice.getAppointmentList(appointmentDate,approvalStatus);
		return new ResponseEntity<List<Appointment>>(appo,HttpStatus.OK);
	}
	
	//working
	@PutMapping(value = "/updateAppointment/{aid}")
	@ApiOperation(value = "update appointment by appointment id")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable int aid,@RequestBody Appointment appo)
	{
		Appointment appointment=aservice.viewAppointment(aid);
		appointment.setAppointmentDate(appo.getAppointmentDate());
		appointment.setApprovalStatus(appo.getApprovalStatus());
		appointment.setDiagnosticCenter(appo.getDiagnosticCenter());
		appointment.setPatient(appo.getPatient());
		appointment.setDiagnosticTests(appo.getDiagnosticTests());
		appointment.setTestResult(appo.getTestResult());
		aservice.addAppointment(appointment);
		return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
	}
	
	
	//working
	@DeleteMapping(value = "/removeAppointment/{appointment_id}")
	@ApiOperation(value = "delete appointment")
	public ResponseEntity<String> removeAppointment(@PathVariable int appointment_id)
	{
		Appointment appointment=aservice.viewAppointment(appointment_id);
		aservice.removeAppointment(appointment);
		return new ResponseEntity<String>("Appointment With ID :" + appointment_id + " Deleted Successfully", HttpStatus.OK);
	}
}