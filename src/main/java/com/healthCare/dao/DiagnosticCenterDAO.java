package com.healthCare.dao;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthCare.model.DiagnosticCenter;


@Repository
public interface DiagnosticCenterDAO extends JpaRepository<DiagnosticCenter,Integer> {

	public Optional<DiagnosticCenter> findByName(String centername);

	



	
	




} 


