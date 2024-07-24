package com.thazin.employee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thazin.employee.model.entity.Department;
import com.thazin.employee.model.entity.Employee;
import com.thazin.employee.model.repo.DepartmentRepo;
import com.thazin.employee.model.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final List<String> SKILLS = List.of("Communication", "Problem Solving", "Leadership", "Skills Management", "Critical Thinking", "Customer Service", "Adaptabiilty");
	
	private final EmployeeService service;
	private final DepartmentRepo repo;
	
	@GetMapping
	public String listAll(ModelMap map) {
		map.put("employees", service.findAll());
		map.put("departmentName", "");
		return "employee/list";
	}
	
	@GetMapping("form")
	public String form(ModelMap map) {
		map.put("employee", new Employee());
		map.put("skillList", SKILLS);
		return "employee/form";
	}
	
	@GetMapping("param")
	public String findByDepartment(@RequestParam(required = false) String departmentName, ModelMap map) {
		var result = service.find(departmentName);
		map.put("employees",result);
		map.put("departmentName", departmentName);
		return "employee/list";
	}
	
	@GetMapping("detail/{id}")
	public String getDetail(@PathVariable("id") int employeeId, ModelMap map) {
		var selectedEmployee = service.findById(employeeId);
		map.put("employee", selectedEmployee);
		return "employee/detail";
	}
	
	@PostMapping("form")
	public String save(@Valid @ModelAttribute Employee employee, BindingResult result, ModelMap map, RedirectAttributes redirect) {
		var message = employee.getId() > 0 ? "Employee updated successfully." : "New employee created successfully.";
		if(result.hasErrors()) {
			map.put("skillList", SKILLS);
			map.put("employee", employee);
			return "employee/form";
		}
		service.save(employee);
		redirect.addFlashAttribute("message", message);
		return "redirect:/employees";
	}
	
	@PostMapping("edit/{id}")
	public String update(@PathVariable("id") int employeeId, ModelMap map) {
		var employeeToUpdate = service.findById(employeeId);
		map.put("skillList", SKILLS);
		map.put("employee", employeeToUpdate);
		return "employee/form";
	}
	
	@PostMapping("delete/{id}")
	public String delete(@PathVariable("id") int employeeId, RedirectAttributes redirect) {
		service.delete(employeeId);
		redirect.addFlashAttribute("message", "Employee deleted successfully!");
		return "redirect:/employees";
	}

	@ModelAttribute("departments")
	public List<Department> departments() {
		return repo.findAll();
	}
	
}
