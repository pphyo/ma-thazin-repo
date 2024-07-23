package com.jdc.core;

public class StringUtils {
	
	public static void showMessage(String message) {
		String star = "";
		for(int i = 0, l = message.length(); i < l; i ++) {
			star += "*";
		}
		System.out.println("**".concat(star).concat("**"));
		System.out.println("* ".concat(message).concat(" *"));
		System.out.println("**".concat(star).concat("**"));
	}

}
