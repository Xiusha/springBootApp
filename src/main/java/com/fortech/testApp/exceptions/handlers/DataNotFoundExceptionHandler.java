package com.fortech.testApp.exceptions.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fortech.testApp.exceptions.DataNotFoundException;

@ControllerAdvice
public class DataNotFoundExceptionHandler
{
   @ResponseBody
   @ExceptionHandler(DataNotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   ResponseEntity<Object> dataNotFoundHandler( final DataNotFoundException ex )
   {
      return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

}
