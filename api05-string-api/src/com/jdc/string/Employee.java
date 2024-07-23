package com.jdc.string;

import java.util.Objects;

public class Employee {

	private String name;
	private double salary;
	private String phone;

	public Employee(String name, double salary, String phone) {
		super();
		this.name = name;
		this.salary = salary;
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getPhone() {
		return phone;
	}

}
