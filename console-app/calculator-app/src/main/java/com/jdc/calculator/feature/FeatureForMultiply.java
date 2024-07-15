package com.jdc.calculator.feature;

public class FeatureForMultiply extends CalcuatorFeature {

	public FeatureForMultiply() {
		super(3, "Multiply");
	}
	
	@Override
	public void doBusiness() {
		calculate(Operator.MULTIPLY);
	}
	
}
