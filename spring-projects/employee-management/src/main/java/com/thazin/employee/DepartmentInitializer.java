package com.thazin.employee;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thazin.employee.model.entity.Department;
import com.thazin.employee.model.repo.DepartmentRepo;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DepartmentInitializer {
	
	private final DepartmentRepo repo;
	
	@Bean
	ApplicationRunner applicationRunner() {
		return args -> {
			if(repo.count() == 0L) {
				var sales = new Department();
				sales.setName("Sales");
				
				var marketing = new Department();
				marketing.setName("Marketing");
				
				var it = new Department();
				it.setName("I.T");
				
				var hr = new Department();
				hr.setName("HR");
				
				var accounting = new Department();
				accounting.setName("Accounting");
				
				var finance = new Department();
				finance.setName("Finance");
				
				var admin = new Department();
				admin.setName("Administrative");
				
				repo.saveAll(List.of(sales, marketing, it, hr, accounting, finance, admin));
			}
		};
	}

}
