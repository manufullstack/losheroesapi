package cl.losheroes.springboot.api.v1.controllers.exceptions;

public class RepeatedEmailException extends RuntimeException {

	private static final String DESCRIPTION = "Repeated";


	public RepeatedEmailException(String error) {
		super(DESCRIPTION+" : "+error);

	}




}