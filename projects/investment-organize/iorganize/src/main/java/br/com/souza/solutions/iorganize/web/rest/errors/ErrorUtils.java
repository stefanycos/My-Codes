package br.com.souza.solutions.iorganize.web.rest.errors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import br.com.souza.solutions.iorganize.web.rest.dto.ErrorResponse;

public class ErrorUtils {

	private ErrorUtils() {
	}

	public static ErrorResponse buildErrorResponse(HttpStatus httpStatus, String message, HttpServletRequest request) {
		ErrorResponse error = new ErrorResponse(httpStatus);
		error.setMessage(message);
		error.setPath(request.getRequestURI());

		return error;
	}

}
