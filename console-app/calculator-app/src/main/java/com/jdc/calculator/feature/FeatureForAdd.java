package com.jdc.calculator.feature;

public class FeatureForAdd extends CalcuatorFeature {

	public FeatureForAdd() {
		super(1, "Add");
	}

	@Override
	public void doBusiness() {
		calculate(Operator.ADD);
	}

}
