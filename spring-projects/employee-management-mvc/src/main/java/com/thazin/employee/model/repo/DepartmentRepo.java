package com.thazin.employee.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thazin.employee.model.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
