package com.jdc.calculator.feature;

public class FeatureForDivide extends CalculatorFeature {
	
	public FeatureForDivide() {
		super(4, "Divide");
	}
	
	@Override
	public void doBusiness() {
		calculate(Operator.DIVIDE);
	}

}
