package com.springboot.exceptionalHandling.Exception;

import java.util.Date;

public class ApiException {

	private final String message;
	private final Date date;
	public ApiException(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public Date getDate() {
		return date;
	}
	
	
	
	
}
