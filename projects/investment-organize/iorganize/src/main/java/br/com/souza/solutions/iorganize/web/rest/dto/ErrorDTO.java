package br.com.souza.solutions.iorganize.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime timestamp;

	private Integer status;

	private String error;

	private String message;

	private String path;

	public ErrorDTO(HttpStatus httpStatus) {
		timestamp = LocalDateTime.now();
		status = httpStatus.value();
		error = httpStatus.getReasonPhrase();
	}

}
