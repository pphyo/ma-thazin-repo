package com.jdc.app;

public enum Course {
	JavaSE("Java SE", 300_000),
	JavaEE("Java EE", 450_000),
	Spring("Spring Framework", 500_000),
	OneStop("One Stop", 950_000);
	
	private String courseName;
	private double fees;
	
	Course(String courseName, double fees) {
		this.courseName = courseName;
		this.fees = fees;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public double getFees() {
		return fees;
	}
}
