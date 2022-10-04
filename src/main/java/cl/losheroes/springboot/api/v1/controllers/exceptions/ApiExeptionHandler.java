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
		return new ErrorSkeleton(error.getMessage(),"No existen o no se encontraron los recursos solicitados.",HttpStatus.NOT_FOUND,404,"El recurso no existe o no se encuentra.");

	}
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST )
	@ExceptionHandler(RepeatedEmailException.class)
	@ResponseBody
	public ErrorSkeleton repeatedEmailException(RuntimeException error){
		
		return new ErrorSkeleton(error.getMessage(),"Email repetido, no pueden haber 2 emails iguales. Intenta con otro.",HttpStatus.BAD_REQUEST,400,"No pueden existir emails repetidos.");

	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST )
	@ExceptionHandler(RepeatedRutException.class)
	@ResponseBody
	public ErrorSkeleton repeatedRutException(RuntimeException error){
		
		return new ErrorSkeleton(error.getMessage(),"Rut repetido, no pueden haber 2 ruts iguales. Intenta con otro.",HttpStatus.BAD_REQUEST,400,"No pueden existir ruts repetidos.");

	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST )
	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public ErrorSkeleton badRequestException(RuntimeException error){
		
		return new ErrorSkeleton(error.getMessage(),"La solicitud no ha podido ser procesada.",HttpStatus.BAD_REQUEST,400,"El formato o algun recurso son incorrectos.");

	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT )
	@ExceptionHandler(NotContentException.class)
	@ResponseBody
	public ErrorSkeleton notContentException(RuntimeException error){
		
		return new ErrorSkeleton(error.getMessage(),"La solicitud ha sido aceptada.",HttpStatus.NO_CONTENT,204,"Se acepto la solicitud pero no existen datos para devolver.");

	}
	

}
