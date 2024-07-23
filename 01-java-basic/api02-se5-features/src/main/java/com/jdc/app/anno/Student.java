package com.jdc.app.anno;

@Init(ok = false, value = { "Hello", "Java", "Angular" })
public class Student {

//	private static int count;
	private String name;
	
	public Student() {
	}
	
	// property
	public String getName() {
		return name;
	}
	
	void learn() {}
	
}

@Init(ok = true)
interface CanLearn {
	void learn();
}
