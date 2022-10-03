package cl.losheroes.springboot.api.v1.controllers.exceptions;

public class RepeatedException extends RuntimeException {

	private static final String DESCRIPTION = "Repeated";


	public RepeatedException(String error) {
		super(error);

	}




}
