package com.SortingAlgorithm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.SortingAlgorithm.exceptions.InvalidArrayInputException;
import com.SortingAlgorithm.exceptions.SortingException;

@ControllerAdvice
public class ExceptionsHandler {

 @ExceptionHandler(InvalidArrayInputException.class)
public ResponseEntity<Object> handleInvalidArrayInputException(InvalidArrayInputException ex) {
	 return ResponseEntity.badRequest().body(ex.getMessage());
}
 
 @ExceptionHandler(SortingException.class)
 public ResponseEntity<Object> handleSortingException(SortingException ex) {
 	 return ResponseEntity.badRequest().body(ex.getMessage());
 }
 
 @ExceptionHandler(Exception.class)
 public ResponseEntity<Object> handleException(Exception ex) {
 	 return ResponseEntity.badRequest().body(ex.getMessage());
 }
}