package com.healthCare.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.healthCare.dao.AppointmentDAO;

import com.healthCare.service.IAppointmentService;

@SpringBootTest
public class TestAppointmentService {

	@MockBean
	private AppointmentDAO appointmentDao;
	@Autowired
	private IAppointmentService appointmentService;
	
}
