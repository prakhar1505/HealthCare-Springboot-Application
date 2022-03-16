package com.healthCare.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.healthCare.model.*;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer>
{
	
	  @Query("SELECT p FROM Patient p WHERE p.pname = ?1") 
	  Optional<Patient> findByName(String patientName);
	  

		@Query("select p.patientId from Patient p where p.pname=?1")
		Optional<List<Integer>> findId(String patientName);
}