package com.jdc.core;

import java.util.Scanner;

public class InputUtils {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static String readString(String prompt) {
		System.out.print(prompt);
		var result = scanner.nextLine();
		return result;
	}
	
	public static int readInt(String prompt) {
		var resultString = readString(prompt);
		return Integer.parseInt(resultString);
	}
	
	public static Scanner scanner() {
		return scanner;
	}

}
