package com.thazin.employee.api;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thazin.employee.model.SimplePayload;
import com.thazin.employee.model.PayloadForUpdate;
import com.thazin.employee.model.input.DepartmentInput;
import com.thazin.employee.model.output.DepartmentOutput;
import com.thazin.employee.model.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("departments")
@RequiredArgsConstructor
public class DepartmentApi {
	
	private final DepartmentService service;

	@PostMapping("new")
	public PayloadForUpdate<DepartmentOutput> createNew(@Validated @RequestBody DepartmentInput input, BindingResult result) {
		return service.create(input);
	}
	
	@PutMapping("update/{id:\\d+}")
	public PayloadForUpdate<DepartmentOutput> update(@PathVariable int id, @Validated @RequestBody DepartmentInput input, BindingResult result) {
		return service.update(id, input);
	}
	
	@GetMapping("search")
	public SimplePayload<List<DepartmentOutput>> findAll() {
		return service.findAll();
	}
	
	@GetMapping("search/{id:\\d+}")
	public SimplePayload<DepartmentOutput> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
}
