package com.healthCare.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthCare.model.Appointment;

public interface AppointmentDAO extends JpaRepository<Appointment,Integer> {

	@Query("select a from Appointment a, Patient p where a.patient.patientId=?1")
	Optional<List<Appointment>> findAppointmentByPid(Integer patient_id);

	
	@Query("select a from Appointment a where a.appointmentDate=?1 and a.approvalStatus=?2")
	Optional<List<Appointment>> findAppointmentByStatus(Date appointmentDate,String approvalStatus);

}