package com.ust.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BookAPIException.class)
	public ResponseEntity<String> handleException(BookAPIException bookAPIException) {
		return new ResponseEntity<String>(bookAPIException.getErrorMessage(),
				bookAPIException.getHttpStatus());
	}
	

}
