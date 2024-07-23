package com.jdc.string;

public class StringPoolApp {

	public static void main(String[] args) {
		
		var x = "Hello World";
		var z = " Hello World".trim();
		
		System.out.println(x == z);
		
		var str = "Hello World";
		var concat = "Hello";
		concat = concat.concat(" World");
		
		System.out.println(concat);
		System.out.println(str == concat);
		
		var s1 = "a" + "b" + "c" + 1;
		var s2 = "abc" + 1;
		System.out.println(s1 == s2);

	}

}
