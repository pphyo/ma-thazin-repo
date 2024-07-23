package com.jdc.student.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleHandler {
	
	private static ResourceBundle resource = ResourceBundle.getBundle("language", Locale.ENGLISH);

	public static ResourceBundle getResource() {
		return resource;
	}

	public static void setResource(ResourceBundle resource) {
		ResourceBundleHandler.resource = resource;
	}

}
