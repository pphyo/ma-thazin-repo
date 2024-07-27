package com.thazin.employee.model.output;

import java.util.List;

import com.thazin.employee.model.entity.Employee;

public record EmployeeOutput(int id, String name, List<String> skills, DepartmentOutput department) {

	public static EmployeeOutput from(Employee entity) {
		return new EmployeeOutput(entity.getId(), entity.getName(), entity.getSkills(), DepartmentOutput.from(entity.getDepartment()));
	}

}
