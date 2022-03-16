package com.healthCare.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.healthCare.exception.ApointmentNotFoundException;
import com.healthCare.exception.CenterNotFoundException;
import com.healthCare.exception.InvalidUsernameException;
import com.healthCare.exception.PatientNotFoundException;
import com.healthCare.exception.TestNotFoundException;
import com.healthCare.exception.TestResultNotFoundException;
import com.healthCare.exception.UsernameAlreadyExistsException;
import com.healthCare.exception.UsernameNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CenterNotFoundException.class)
	public ResponseEntity<String> handleCenterNotFound(CenterNotFoundException cnfe)
	{
		return new ResponseEntity<String>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidUsernameException.class)
	public ResponseEntity<String> handleUserNotFound(InvalidUsernameException iue) {
		return new ResponseEntity<String>(iue.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> handleUsernameNotFound(UsernameNotFoundException unf) {
		return new ResponseEntity<String>(unf.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(TestNotFoundException.class)
	public ResponseEntity<String> handleTestNotFound(TestNotFoundException tnfe)
	{
		return new ResponseEntity<String>(tnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<String> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException tnfe)
	{
		return new ResponseEntity<String>(tnfe.getMessage(),HttpStatus.CONFLICT);
	}
	@ExceptionHandler(TestResultNotFoundException.class)
	public ResponseEntity<String> handleTestResultNotFoundException(TestResultNotFoundException tnfe)
	{
		return new ResponseEntity<String>(tnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ApointmentNotFoundException.class)
	public ResponseEntity<String> handleCenterNotFound(ApointmentNotFoundException cnfe)
	{
		return new ResponseEntity<String>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> handleCenterNotFound(PatientNotFoundException cnfe)
	{
		return new ResponseEntity<String>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
}