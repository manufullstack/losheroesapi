package cl.losheroes.springboot.api.v1.controllers.exceptions;

import org.springframework.http.HttpStatus;


public class ErrorSkeleton {

	private String error;

	private String message;

	private HttpStatus status;
	
	private int code;

	private String detail;

	public ErrorSkeleton(String error, String message, HttpStatus status, int code, String detail) {
		
		this.error = error;
		this.message = message;
		this.status = status;
		this.code = code;
		this.detail = detail;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public int getCode() {
		return code;
	}

	public String getDetail() {
		return detail;
	}





}
