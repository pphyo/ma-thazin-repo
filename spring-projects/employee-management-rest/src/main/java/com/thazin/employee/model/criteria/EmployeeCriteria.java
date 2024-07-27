package com.thazin.employee.model.criteria;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.thazin.employee.model.entity.Employee;

public record EmployeeCriteria(String departmentName) {
	
	public Specification<Employee> where() {
		Specification<Employee> spec = Specification.where(null);
		
		if(StringUtils.hasText(departmentName)) {
			spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("department").get("name")), departmentName.toLowerCase().concat("%")));
		}
		
		return spec;
	}

}
