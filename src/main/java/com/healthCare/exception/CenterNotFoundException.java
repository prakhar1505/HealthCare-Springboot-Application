package com.healthCare.exception;


public class CenterNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;


		public CenterNotFoundException() {
			// TODO Auto-generated constructor stub
		}
		
		
		public CenterNotFoundException(String msg)
		{
			super(msg);
		}
		
	}
