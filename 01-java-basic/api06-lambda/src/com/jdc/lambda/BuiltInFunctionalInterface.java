package com.jdc.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterface {

	public static void main(String[] args) {
		runForSupplier();
	}
	
	static void runForSupplier() {
		Supplier<String> sup = () -> "Hello Supplier";
		System.out.println(sup.get());
	}
	
	static void runForPredicate() {
		Predicate<Integer> isEven = i -> i % 2 == 0;
		Predicate<Integer> isGreaterThanFive = i -> i > 5;
		
		System.out.println(isEven.and(isGreaterThanFive).test(10));
	}
	
	static void runForFunction() {
		
		Function<String, Integer> strToInt = Integer::parseInt;
		System.out.println("String to Int: " + strToInt.apply("100"));
		
		Function<Integer, String> intToStr = String::valueOf;
		System.out.println("Int to String: " + intToStr.apply(200));
		
		Function<Integer, Integer> twice = i -> i * 2;
		Function<Integer, Integer> square = i -> i * i;
		
		var result = twice.andThen(square).andThen(twice).apply(3);
		
		result = square.compose(twice).compose(twice).apply(3);
		
		System.out.println("Result: " + result);
		
	}

	static void runForConsumer() {

//		Consumer<String> strCon = BuiltInFunctionalInterface::greet;
//		strCon.accept("Kyaw Kyaw");
//
//		Consumer<Integer> intCon = i -> System.out.println(i * 2);
//		intCon.accept(20);
		
		ConsumerStudent cs = new ConsumerStudent();
		
		Consumer<String> studentNameCon = cs::setName;
		studentNameCon.accept("Nyi Nyi");
		
		Consumer<Integer> studentAgeCon = i -> cs.setAge(i);
		studentAgeCon.accept(20);

		System.out.println("Name: %s".formatted(cs.getName()));
		System.out.println("Age: %d".formatted(cs.getAge()));
		
		Consumer<String> con1 = str -> System.out.println("Consumer 1: ".concat(str));
		Consumer<String> con2 = str -> System.out.println("consumer 2: ".concat(str));
		
		con1.andThen(con1).andThen(con2).accept("andThen");
	}

	static void greet(String name) {
		System.out.println("Hello %s!".formatted(name));
	}
}

class ConsumerStudent {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
