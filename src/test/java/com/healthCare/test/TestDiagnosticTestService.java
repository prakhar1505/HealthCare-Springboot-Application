package com.healthCare.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.healthCare.dao.DiagnosticTestDAO;
import com.healthCare.dao.IDiagnosticCenterRepository;
import com.healthCare.dao.IDiagnosticTestRepository;
import com.healthCare.model.DiagnosticTest;
import com.healthCare.service.IDiagnosticTestService;

@SpringBootTest
public class TestDiagnosticTestService {
	@MockBean
	private DiagnosticTestDAO diagTestRep;
	@Autowired
	private IDiagnosticTestService diagTestService;
	
	@Test
	public void testAddNewTest() {
		Optional<DiagnosticTest> dt=Optional.ofNullable(new DiagnosticTest(1, "Blood", 120.0, "120", "mg/L", null));
		when(diagTestRep.save(dt.get())).thenReturn(dt.get());
		when(diagTestRep.findById(dt.get().getTestId())).thenReturn(dt);
		assertEquals(dt.get().getTestId(), diagTestService.addNewTest(dt.get()).getTestId());
	}
	@Test
	public void testUpdateTestDetail() {
		Optional<DiagnosticTest> dt=Optional.ofNullable(new DiagnosticTest(1, "Blood", 122.0, "120", "mg/L", null));
		when(diagTestRep.save(dt.get())).thenReturn(dt.get());
		when(diagTestRep.findById(dt.get().getTestId())).thenReturn(dt);
		assertEquals(dt.get().getTestPrice(), diagTestService.updateTestDetail(dt.get()).getTestPrice());
	}
	@Test
	public void testGetAllTest() {
		Optional<DiagnosticTest> dt=Optional.ofNullable(new DiagnosticTest(1, "Blood", 120.0, "120", "mg/L", null));
		when(diagTestRep.save(dt.get())).thenReturn(dt.get());
		when(diagTestRep.findById(dt.get().getTestId())).thenReturn(dt);
		List<DiagnosticTest> list=new ArrayList<DiagnosticTest>();
		list.add(dt.get());
		when(diagTestRep.findAll()).thenReturn(list);
		assertEquals(dt.get().getTestId(), diagTestService.getAllTest().get(0).getTestId());
	}
}