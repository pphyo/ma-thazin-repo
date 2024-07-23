package com.jdc.collection.test;

public class Employee implements Comparable<Employee> {

	private String name;
	private double salary;
	private String phone;
	private int workHour;

	public Employee(String name, double salary, String phone, int workHour) {
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.workHour = workHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getWorkHour() {
		return workHour;
	}

	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", salary=" + salary + ", phone=" + phone + ", workHour=" + workHour + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return name.compareTo(o.getName());
	}

}
