package com.healthCare.exception;

public class PatientNotFoundException extends RuntimeException {



	public PatientNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PatientNotFoundException(String msg)
	{
		super(msg);
	}
}