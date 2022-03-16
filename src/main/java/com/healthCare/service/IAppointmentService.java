package com.healthCare.service;

import java.util.Date;
import java.util.List;
import com.healthCare.model.Appointment;

public interface IAppointmentService {

	public Appointment addAppointment(Appointment appointment);
	
	public List<Appointment> viewAppointments(String patientName);
	
	public Appointment viewAppointment(int appointmentId);
	
	public Appointment updateAppointment(Appointment appointment);
	
	public List<Appointment> getAppointmentList(Date appointmentDate,String approvalStatus);
	
	public Appointment removeAppointment(Appointment appointment);
	
}
