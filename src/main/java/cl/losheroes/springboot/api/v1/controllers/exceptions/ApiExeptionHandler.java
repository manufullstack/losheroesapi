package cl.losheroes.springboot.api.v1.controllers.exceptions;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExeptionHandler {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ErrorSkeleton notFoundException(RuntimeException error){
		return new ErrorSkeleton(error.getMessage(),"No existen o no se encontraron",HttpStatus.NOT_FOUND,404,"dakljdaskjaklj");

	}
	
	
	@ResponseStatus(code = HttpStatus.CONFLICT )
	@ExceptionHandler(RepeatedException.class)
	@ResponseBody
	public ErrorSkeleton repeatedEmail(RuntimeException error){
		
		return new ErrorSkeleton(error.getMessage(),"Email repetido, no pueden haber 2 email iguales. intenta con otro.",HttpStatus.CONFLICT,409,"434343432rwed");

	}

}
