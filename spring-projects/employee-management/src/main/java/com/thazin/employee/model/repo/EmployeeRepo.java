package com.thazin.employee.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thazin.employee.model.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	List<Employee> findByDepartmentName(String departmentName);
}
