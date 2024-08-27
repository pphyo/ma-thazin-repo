package com.jdc.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalCalculator {
	
	public static void main(String[] args) {
		
		Function<Operator, BiFunction<Double, Double, Double>> calFunc = FunctionalCalculator::calculate;
		
		var result = calFunc.apply(Operator.PLUS).apply(10.0, 20.0);
		
		System.out.println("Result: " + result);
	}
	
	static BiFunction<Double, Double, Double> calculate(Operator ope) {
		return switch(ope) {
			case PLUS -> (a, b) -> a + b;
			case MINUS -> (a, b) -> a - b;
			case TIMES -> (a, b) -> a * b;
			case DIVIDE -> (a, b) -> a / b;
			case MOD -> (a, b) -> a % b;
			default -> throw new IllegalArgumentException();
		};
	}
	
	public enum Operator {
		PLUS, MINUS, TIMES, DIVIDE, MOD
	}

}
