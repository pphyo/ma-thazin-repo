package com.jdc.app;

public class Data {
	
	private Data() {
	}
	
	public static void sumArray(int[] intArr) {
		System.out.println(intArr);
	}
	
	// 0 or more
	public static void sumVarargs(String message, int... numbers) {
		System.out.println(numbers.length);
	}
	
	public static String getInt(Integer i) {
		if(i > 0) {
			return "Hello";
		}
		return null;
	}
	
	public static void main(String[] args) {
		Integer i = null;
		getInt(i);
	}
	
}
