package com.jdc.calculator;

import com.jdc.calculator.feature.FeatureForAdd;
import com.jdc.calculator.feature.FeatureForDivide;
import com.jdc.calculator.feature.FeatureForMultiply;
import com.jdc.calculator.feature.FeatureForTakeaway;
import com.jdc.core.ConsoleApplication;

public class CalculatorApplication {

	public static void main(String[] args) {
		var application = new ConsoleApplication(
					"Calculator App",
					new FeatureForAdd(),
					new FeatureForTakeaway(),
					new FeatureForMultiply(),
					new FeatureForDivide()
				);
		application.launch();
	}
	
}
