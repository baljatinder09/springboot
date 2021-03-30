package com.social.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.social.UserAleadyExistException;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorStatus> handleAllException(Exception ex, WebRequest request) throws Exception {
		System.out.println("Exception");
		ErrorStatus errorStatus = new ErrorStatus(ex.getMessage(), ex.getLocalizedMessage(), new Date(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ErrorStatus>(errorStatus, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorStatus> handleConstraintViolationException(HttpServletResponse  response,Exception ex, WebRequest request) throws Exception {
		System.out.println("handleConstraintViolationException ConstraintViolationException");
		ErrorStatus errorStatus = new ErrorStatus(ex.getMessage(), ex.getLocalizedMessage(), new Date(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	    return new ResponseEntity<ErrorStatus>(errorStatus, HttpStatus.BAD_REQUEST);
		//response.sendError(HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorStatus> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		System.out.println("UserNotFoundException");
		ErrorStatus errorStatus = new ErrorStatus(ex.getMessage(), ex.getLocalizedMessage(), new Date(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorStatus>(errorStatus, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserAleadyExistException.class)
	public ResponseEntity<ErrorStatus> handleUserAleadyExistException(Exception ex, WebRequest request)
			throws Exception {
		System.out.println("UserAleadyExistException");
		ErrorStatus errorStatus = new ErrorStatus(ex.getMessage(), ex.getLocalizedMessage(), new Date(),
				HttpStatus.FOUND);
		return new ResponseEntity<ErrorStatus>(errorStatus, HttpStatus.FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());		
		Map<String, String> errors = ex.getBindingResult().getAllErrors().stream().collect(Collectors.toMap(error ->
			((FieldError) error).getField(), error -> 
			((FieldError) error).getDefaultMessage()));
		/*ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});*/
		body.put("errors",errors);
		return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
	}
}
