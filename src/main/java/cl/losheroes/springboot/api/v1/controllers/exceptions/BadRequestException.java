package cl.losheroes.springboot.api.v1.controllers.exceptions;

public class BadRequestException extends RuntimeException {

	private static final String DESCRIPTION = "Bad Request";


	public BadRequestException(String error) {
		super(DESCRIPTION+" : "+error);


	}




}