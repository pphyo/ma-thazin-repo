package com.jdc.string;

public class StringApiApp {

	public static void main(String[] args) {
		
//		String litStr1 = "Hello";
//		String litStr2 = "Hello";
//		
//		String objStr1 = new String("Hello");
//		
//		System.out.println("Literal 1 == Literal 2: " + (litStr1 == litStr2));
//		System.out.println("Literal 1 == Object 1: " + (litStr1 == objStr1));
//		System.out.println("Literal 1 equals Object 1: " + litStr1.equals(objStr1));
		
		String str1 = "Hello ";
		
		str1 = str1.concat(" World");
		
		System.out.println(str1);
		System.out.println(1 + 2);
		System.out.println("a" + "b");
		System.out.println("a" + "b" + 3);
		System.out.println(1 + 2 + "c");
		System.out.println("c" + 1 + 2);
		System.out.println("c" + null);
		
		var s = "1";
		s += "2";
		s += 3;
		System.out.println(s);
		
		var name = " ";
		System.out.println(name.length());
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(6));
//		System.out.println(name.charAt(7)); // SIOFBE
		
		System.out.println(name.indexOf("ml"));
		System.out.println(name.substring(3));
		System.out.println(name.substring(3, 6));
		
		System.out.println(name.toLowerCase());
		System.out.println(name.toUpperCase());
		
		System.out.println(name.equals("animals123"));
		System.out.println(name.equalsIgnoreCase("animals123"));
		
		

	}
	
	static void checkEmployee() {
		System.out.println();
		var emp1 = new Employee("Ada", 33000, "019393233");
		var emp2 = new Employee("Adam", 30000, "019393233");
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp1.equals(emp2));
	}

}
