package com.jdc.student.utils;

import static com.jdc.student.utils.ResourceBundleHandler.getResource;

import com.jdc.student.utils.exception.StudentManagementException;

public class ValidationHandler {
	
	public static void checkId(int id) {
		if(id < 1) {
			throw new StudentManagementException(getResource().getString("app.exception.check.id"));
		}
	}

}
