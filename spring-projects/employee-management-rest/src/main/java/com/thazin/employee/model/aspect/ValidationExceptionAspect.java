package com.thazin.employee.model.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import com.thazin.employee.model.exception.ApiValidationException;

@Configuration
@Aspect
public class ValidationExceptionAspect {

	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void apiClasses() {}
	
	@Before(value = "apiClasses() && args(.., result)", argNames = "result")
	public void validate(BindingResult result) {
		if(result.hasErrors()) {
			throw new ApiValidationException(result.getFieldErrors().stream().map(error -> error.getDefaultMessage()).toList());
		}
	}

}
