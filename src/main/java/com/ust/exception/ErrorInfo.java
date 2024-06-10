package com.ust.exception;

import java.time.LocalDateTime;

public class ErrorInfo {
	
	private String errorMessage;
	private LocalDateTime localDateTime;
	public ErrorInfo() {
		super();
	}
	public ErrorInfo(String errorMessage, LocalDateTime localDateTime) {
		super();
		this.errorMessage = errorMessage;
		this.localDateTime = localDateTime;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	

}
