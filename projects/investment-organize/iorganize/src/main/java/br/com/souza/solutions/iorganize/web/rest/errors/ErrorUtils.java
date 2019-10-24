package br.com.souza.solutions.iorganize.web.rest.errors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import br.com.souza.solutions.iorganize.web.rest.dto.ErrorDTO;

public class ErrorUtils {

	private ErrorUtils() {
	}

	public static ErrorDTO buildErrorResponse(HttpStatus httpStatus, String message, HttpServletRequest request) {
		ErrorDTO error = new ErrorDTO(httpStatus);
		error.setMessage(message);
		error.setPath(request.getRequestURI());

		return error;
	}

}
