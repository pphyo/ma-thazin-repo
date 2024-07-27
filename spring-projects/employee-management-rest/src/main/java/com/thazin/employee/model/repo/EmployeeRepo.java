package com.thazin.employee.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.thazin.employee.model.entity.Employee;

public interface EmployeeRepo extends JpaRepositoryImplementation<Employee, Integer> {
}
