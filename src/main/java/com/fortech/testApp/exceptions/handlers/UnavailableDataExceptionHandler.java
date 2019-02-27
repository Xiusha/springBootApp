package com.fortech.testApp.exceptions.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fortech.testApp.exceptions.UnavailableDataException;

public class UnavailableDataExceptionHandler {

	   @ResponseBody
	   @ExceptionHandler(UnavailableDataException.class)
	   @ResponseStatus(HttpStatus.NOT_FOUND)
	   ResponseEntity<Object> unavailableDataHandler( final UnavailableDataException ex )
	   {
	      return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	   }

}
