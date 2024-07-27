package com.thazin.employee.model.input;

import java.util.List;
import java.util.function.Function;

import com.thazin.employee.model.entity.Department;
import com.thazin.employee.model.entity.Employee;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record EmployeeInput(
		@NotBlank(message = "Employee name is required!")
		String name,
		@NotEmpty(message = "At least one skill is required!")
		List<String> skills,
		@Min(value = 1, message = "Department is required!")
		int departmentId
		) {
	
	public Employee entity(Function<Integer, Department> departmentMapper) {
		var employee = new Employee();
		employee.setName(name);
		employee.setSkills(skills);
		employee.setDepartment(departmentMapper.apply(departmentId));
		return employee;
	}

}
