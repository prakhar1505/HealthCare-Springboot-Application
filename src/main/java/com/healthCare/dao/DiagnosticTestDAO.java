package com.healthCare.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.healthCare.model.DiagnosticCenter;
import com.healthCare.model.DiagnosticTest;

@Repository
public interface DiagnosticTestDAO extends JpaRepository<DiagnosticTest, Integer> {
	//@Query("Select * from DiagnosticTest d where d.centerId=?1")
	public Set<DiagnosticTest> findAllByDiagnosticCenter(DiagnosticCenter center);
	public DiagnosticTest deleteByDiagnosticCenter(DiagnosticCenter center);
	public Optional<DiagnosticTest> findByTestName(String testName);

}
