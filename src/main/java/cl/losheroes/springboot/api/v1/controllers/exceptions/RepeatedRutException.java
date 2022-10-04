package cl.losheroes.springboot.api.v1.controllers.exceptions;

public class RepeatedRutException extends RuntimeException {

	private static final String DESCRIPTION = "Repeated";


	public RepeatedRutException(String error) {
		super(DESCRIPTION+" : "+error);

	}




}

