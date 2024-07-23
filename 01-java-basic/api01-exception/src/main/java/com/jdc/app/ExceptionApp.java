package com.jdc.app;

import java.io.File;
import java.io.IOException;

public class ExceptionApp {

	public static void main(String[] args) {
		
		System.out.println("Program start");
		
		try {
			System.exit(0);
//			runForRE(10);
//			runForCNSE();
//			runForFNF();
		} catch (Exception e) {
			System.out.println("Error Ocurred");
		} finally {
			System.out.println("Finally work");
		}
		
		
		System.out.println("Program stop");
	}
	
	static boolean isEven(int num) {
		if(num % 2 == 0) {
			return true;
		}
		return false;
	}
	
	static String hello(String name) {
		return "Hello %s".formatted(name);
	}
	
	static void runForRE(int num) {
		if(num <= 0)
			return;
		
		System.out.println(3 / 0);
	}
	
	static void runForFNF() throws IOException {
		var file = new File("");
		file.createNewFile();
	}
	
	static void runForCNSE() throws CloneNotSupportedException {
		var user = new User();
		var clone = user.copy("pphyo", "pyaephyo");
		System.out.println(clone.getUsername());
	}
}
