package com.jdc.calculator.feature;

public class FeatureForMultiply extends CalculatorFeature {

	public FeatureForMultiply() {
		super(3, "Multiply");
	}
	
	@Override
	public void doBusiness() {
		calculate(Operator.MULTIPLY);
	}
	
}
