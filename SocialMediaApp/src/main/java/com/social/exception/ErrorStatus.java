package com.social.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorStatus {
	
	private String message;
	private String detail;
	private Date dateTime;
	private HttpStatus errorStatus;
	
	
	
	public ErrorStatus(String message, String detail, Date dateTime, HttpStatus erroStatus) {
		super();
		this.message = message;
		this.detail = detail;
		this.dateTime = dateTime;
		this.errorStatus = erroStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public HttpStatus getErroStatus() {
		return errorStatus;
	}
	public void setErroStatus(HttpStatus erroStatus) {
		this.errorStatus = erroStatus;
	}
	
	
}
