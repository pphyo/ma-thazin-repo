package com.jdc.calculator.feature;

public class FeatureForTakeaway extends CalcuatorFeature {
	
	public FeatureForTakeaway() {
		super(2, "Difference");
	}
	
	@Override
	public void doBusiness() {
		calculate(Operator.TAKE_AWAY);
	}

}
