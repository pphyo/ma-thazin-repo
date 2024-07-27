package com.thazin.employee.model.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thazin.employee.model.PayloadForUpdate;
import com.thazin.employee.model.SimplePayload;
import com.thazin.employee.model.entity.Department;
import com.thazin.employee.model.exception.ApiBusinessException;
import com.thazin.employee.model.input.DepartmentInput;
import com.thazin.employee.model.output.DepartmentOutput;
import com.thazin.employee.model.repo.DepartmentRepo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {
	
	private final DepartmentRepo repo;
	
	@Transactional
	public PayloadForUpdate<DepartmentOutput> create(@Valid DepartmentInput input) {
		var department = repo.save(input.entity());
		var output = DepartmentOutput.from(department);
		return new PayloadForUpdate<DepartmentOutput>(output, "Department created successfully.");
	}
	
	@Transactional
	public PayloadForUpdate<DepartmentOutput> update(int id, @Valid DepartmentInput input) {
		var department = repo.findById(id).map(dep -> {
							dep.setName(input.name());
							return dep;
						}).orElseThrow(supplyException(id));
		var output = DepartmentOutput.from(department);
		return new PayloadForUpdate<DepartmentOutput>(output, "Department updated successfully.");
	}
	
	public SimplePayload<List<DepartmentOutput>> findAll() {
		return SimplePayload.success(repo.findAll().stream().map(DepartmentOutput::from).toList());
	}
	
	public SimplePayload<DepartmentOutput> findById(int id) {
		return SimplePayload.success(DepartmentOutput.from(findByIdForInner(id)));
	}

	Department findByIdForInner(int id) {
		return repo.findById(id).orElseThrow(supplyException(id));
	}
	
	private Supplier<RuntimeException> supplyException(int id) {
		return () -> new ApiBusinessException(List.of("No department found with ID %d!".formatted(id)));
	}

}
