package com.thazin.employee.model.exception;

import java.util.List;

public class ApiBusinessException extends ApiBaseException {
	
	private static final long serialVersionUID = 1L;

	public ApiBusinessException(
			List<String> messages) {
		super(messages);
	}

}
