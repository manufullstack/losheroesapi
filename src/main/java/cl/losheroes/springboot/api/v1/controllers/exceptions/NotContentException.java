package cl.losheroes.springboot.api.v1.controllers.exceptions;

public class NotContentException extends RuntimeException {

	private static final String DESCRIPTION = "Not Content";


	public NotContentException(String error) {
		super(DESCRIPTION+" : "+error);


	}




}
