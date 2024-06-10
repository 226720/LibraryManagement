package com.ust.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
@Getter
@Data
@AllArgsConstructor
public class BookAPIException extends RuntimeException {
	private final String errorMessage;
	private final HttpStatus httpStatus;
	

}
