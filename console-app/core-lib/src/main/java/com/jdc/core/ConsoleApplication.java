package com.jdc.core;

import static com.jdc.core.StringUtils.*;
import static com.jdc.core.InputUtils.*;

public class ConsoleApplication {
	
	private String appName;
	private AbstractFeature[] features;
	
	public ConsoleApplication(String appName, AbstractFeature... features) {
		this.appName = appName;
		this.features = features;
	}
	
	public void launch() {
		// show welcome message
		showMessage("Welcome to %s".formatted(appName));
		
		do {
			
			// show all menu and get user selected menu
			AbstractFeature feature = getUserSelectedFeature();
			
			System.out.println();
			
			feature.doBusiness();
			
		} while(askToContinue());
		
		showMessage("Thank you");
		
		// close scanner
		scanner().close();
	}
	
	private AbstractFeature getUserSelectedFeature() {
		
		for(var feature : features) {
			feature.showMenu();
		}
		
		System.out.println();
		var selectedId = readInt("Choose Menu ID: ");
		
		return features[selectedId - 1];
	}

	private boolean askToContinue() {
		System.out.println();
		var result = readString("Do you want to continue?(y/others): ");
		System.out.println();
		return result.equalsIgnoreCase("y");
	}

}
