package br.com.souza.solutions.iorganize.web.rest.errors;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.souza.solutions.iorganize.web.rest.dto.ErrorDTO;

import static br.com.souza.solutions.iorganize.web.rest.errors.ErrorUtils.buildErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorDTO handleConstraintViolation(Exception exception, HttpServletRequest request) {

		return buildErrorResponse(HttpStatus.BAD_REQUEST, "Name already registered.", request);
	}

}
