package com.thazin.employee.api;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thazin.employee.model.SimplePayload;
import com.thazin.employee.model.PayloadForUpdate;
import com.thazin.employee.model.criteria.EmployeeCriteria;
import com.thazin.employee.model.input.EmployeeInput;
import com.thazin.employee.model.output.EmployeeOutput;
import com.thazin.employee.model.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeeApi {
	
	private final EmployeeService service;
	
	@PostMapping("new")
	public PayloadForUpdate<EmployeeOutput> createNew(@Validated @RequestBody EmployeeInput input, BindingResult result) {
		return service.create(input);		
	}
	
	@PutMapping("update/{id:\\d+}")
	public PayloadForUpdate<EmployeeOutput> update(@PathVariable int id, @Validated @RequestBody EmployeeInput input, BindingResult result) {
		return service.update(id, input);
	}
	
	@DeleteMapping("delete/{id:\\d+}")
	public PayloadForUpdate<Integer> delete(@PathVariable int id) {
		return service.delete(id);
	}
	
	@GetMapping("search")
	public SimplePayload<List<EmployeeOutput>> find(EmployeeCriteria criteria) {
		return service.find(criteria);
	}
	
	@GetMapping("search/{id:\\d+}")
	public SimplePayload<EmployeeOutput> findById(@PathVariable int id) {
		return service.findById(id);
	}

}
