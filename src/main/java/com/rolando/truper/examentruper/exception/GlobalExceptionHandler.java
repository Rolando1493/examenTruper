package com.rolando.truper.examentruper.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.rolando.truper.examentruper.bean.DetailError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFound resourceNotFound, WebRequest webrequest){
		DetailError error = new DetailError();
		error.setFecha(new Date());
		error.setMessage(resourceNotFound.getMessage());
		error.setDetail(webrequest.getDescription(false));
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception exception, WebRequest webRequest){
		DetailError error = new DetailError();
		error.setFecha(new Date());
		error.setMessage(exception.getMessage());
		error.setDetail(webRequest.getDescription(false));
		return new ResponseEntity<> (error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
