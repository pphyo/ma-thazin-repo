package com.thazin.employee.model.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thazin.employee.model.PayloadForUpdate;
import com.thazin.employee.model.criteria.EmployeeCriteria;
import com.thazin.employee.model.SimplePayload;
import com.thazin.employee.model.entity.Employee;
import com.thazin.employee.model.exception.ApiBaseException;
import com.thazin.employee.model.input.EmployeeInput;
import com.thazin.employee.model.output.EmployeeOutput;
import com.thazin.employee.model.repo.EmployeeRepo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
	
	private final EmployeeRepo repo;
	private final DepartmentService depService;
	
	public PayloadForUpdate<EmployeeOutput> create(@Valid EmployeeInput input) {
		var entity = repo.save(input.entity(id -> depService.findByIdForInner(id)));
		var output = EmployeeOutput.from(entity);
		return new PayloadForUpdate<EmployeeOutput>(output, "Employee created successfully.");
	}
	
	public PayloadForUpdate<EmployeeOutput> update(int id, @Valid EmployeeInput input) {
		var entity = repo.findById(id).map(emp -> {
						emp.setName(input.name());
						emp.setSkills(input.skills());
						emp.setDepartment(depService.findByIdForInner(input.departmentId()));
						return emp;
					}).orElseThrow(supplyException(id));
		var output = EmployeeOutput.from(entity);
		return new PayloadForUpdate<EmployeeOutput>(output, "Employee updated successfully.");
	}
	
	public PayloadForUpdate<Integer> delete(int id) {
		repo.deleteById(id);
		return new PayloadForUpdate<Integer>(id, "Employee deleted successfully.");
	}
	
	@Transactional(readOnly = true)
	public SimplePayload<List<EmployeeOutput>> find(EmployeeCriteria criteria) {
		var result = repo.findAll(criteria.where());
		return SimplePayload.success(mapToEmployeeOutput(result));
	}
	
	@Transactional(readOnly = true)
	public SimplePayload<EmployeeOutput> findById(int id) {
		var entity = repo.findById(id).orElseThrow(supplyException(id));
		var output = EmployeeOutput.from(entity);
		return SimplePayload.success(output);
	}
		
	private List<EmployeeOutput> mapToEmployeeOutput(List<Employee> employees) {
		return employees.stream().map(EmployeeOutput::from).toList();
	}
	
	private Supplier<RuntimeException> supplyException(int id) {
		return () -> new ApiBaseException(List.of("No employee found with ID %d!".formatted(id)));
	}

}
