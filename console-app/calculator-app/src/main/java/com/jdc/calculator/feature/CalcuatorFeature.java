package com.jdc.calculator.feature;

import com.jdc.core.AbstractFeature;
import com.jdc.core.InputUtils;

public abstract class CalcuatorFeature extends AbstractFeature {

	public CalcuatorFeature(int id, String name) {
		super(id, name);
	}
	
	protected void calculate(Operator ope) {
		var numOne = getNumOne();
		var numTwo = getNumTwo();
		
		var result = switch(ope) {
		case ADD -> numOne + numTwo;
		case TAKE_AWAY -> numOne - numTwo;
		case MULTIPLY -> numOne * numTwo;
		case DIVIDE -> numOne / numTwo;
		default -> throw new IllegalArgumentException("Error!");
		};
		
		System.out.println();
		System.out.println("%d %s %d = %d".formatted(numOne, getOperatorString(ope), numTwo, result));
	}
	
	private char getOperatorString(Operator ope) {
		return switch(ope) {
		case ADD -> '+';
		case TAKE_AWAY -> '-';
		case MULTIPLY -> '\u00D7';
		case DIVIDE -> '\u00F7';
		default -> throw new IllegalArgumentException("Error!");
		};
	}
	
	private int getNumOne() {
		return InputUtils.readInt("Enter num one: ");
	}
	
	private int getNumTwo() {
		return InputUtils.readInt("Enter num two: ");
	}
	
	public enum Operator {
		ADD, TAKE_AWAY, MULTIPLY, DIVIDE
	}

}
