package com.thazin.employee.model.criteria;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.thazin.employee.model.entity.Employee;

public record EmployeeCriteria(String departmentName) {
	
	// select * from employee e join department d on e.id = d.employee_id// where 1 = 1 and lower(d.name) like lower(ACC%)
	public Specification<Employee> where() {
		Specification<Employee> spec = Specification.where(null);
		
		if(StringUtils.hasText(departmentName)) {
			spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("department").get("name")), departmentName.toLowerCase().concat("%")));
		}
		
		return spec;
	}

}
