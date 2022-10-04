package cl.losheroes.springboot.api.v1.controllers.exceptions;

public class NotFoundException extends RuntimeException {

	private static final String DESCRIPTION = "Not Found";


	public NotFoundException(String error) {
		super(DESCRIPTION+" : "+error);

	}




}
