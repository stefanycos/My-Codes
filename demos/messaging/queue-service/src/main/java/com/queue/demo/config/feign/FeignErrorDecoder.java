package com.queue.demo.config.feign;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.queue.demo.exception.UnauthorizedException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() == 401) {
			return new UnauthorizedException();
		}
		
		return new ResponseStatusException(HttpStatus.valueOf(response.status()));
	}

}
