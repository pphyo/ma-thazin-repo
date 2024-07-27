package com.thazin.employee.model.output;

import com.thazin.employee.model.entity.Department;

public record DepartmentOutput(int id, String name) {

	public static DepartmentOutput from(Department department) {
		return new DepartmentOutput(department.getId(), department.getName());
	}

}
