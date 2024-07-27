package com.thazin.employee.model.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thazin.employee.model.entity.Employee;
import com.thazin.employee.model.repo.EmployeeRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
	
	private final EmployeeRepo repo;
	
	public void save(Employee employee) {
		repo.save(employee);
	}
	
//	private void create(Employee employee) {
//		repo.save(employee);
//	}
//	
//	private void update(int id, Employee employee) {
//		repo.findById(id).map(emp -> {
//			emp.setName(employee.getName());
//			emp.setSkills(employee.getSkills());
//			emp.setDepartment(employee.getDepartment());
//			return emp;
//		}).orElseThrow(supplier(id));
//	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> find(String department) {
		return repo.findByDepartmentName(department);
	}
	
	@Transactional(readOnly = true)
	public Employee findById(int id) {
		return repo.findById(id).orElseThrow(supplier(id));
	}

	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return repo.findAll();
	}
	
	private Supplier<RuntimeException> supplier(int id) {
		return () -> new RuntimeException("No employee found with ID %d!".formatted(id));
	}

}
