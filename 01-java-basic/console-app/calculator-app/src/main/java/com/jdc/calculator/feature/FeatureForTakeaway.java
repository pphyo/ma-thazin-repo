package com.jdc.calculator.feature;

public class FeatureForTakeaway extends CalculatorFeature {
	
	public FeatureForTakeaway() {
		super(2, "Difference");
	}
	
	@Override
	public void doBusiness() {
		calculate(Operator.TAKE_AWAY);
	}

}
