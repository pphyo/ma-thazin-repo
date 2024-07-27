package com.thazin.employee.model.input;

import com.thazin.employee.model.entity.Department;

import jakarta.validation.constraints.NotBlank;

public record DepartmentInput(
		@NotBlank(message = "Department name is required!")
		String name
		) {

	public Department entity() {
		var department = new Department();
		department.setName(name);
		return department;
	}

}
