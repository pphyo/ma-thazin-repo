package com.thazin.employee.model.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.thazin.employee.model.SimplePayload;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public SimplePayload<List<String>> handle(ApiValidationException exception) {
		return SimplePayload.validation(exception.getMessages());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public SimplePayload<List<String>> handle(ApiBusinessException exception) {
		return SimplePayload.business(exception.getMessages());
	}
		
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public SimplePayload<List<String>> handle(RuntimeException exception) {
		exception.printStackTrace();
		return SimplePayload.business(List.of(exception.getMessage()));
	}

}
