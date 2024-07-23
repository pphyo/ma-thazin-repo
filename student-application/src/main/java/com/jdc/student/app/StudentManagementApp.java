package com.jdc.student.app;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class StudentManagementApp {

	public static void main(String[] args) {
		final String baseName = "language";
		Locale mya = Locale.of("mya", "MM");
		
		ResourceBundle rb = ResourceBundle.getBundle(baseName, mya);
		System.out.println(MessageFormat.format(rb.getString("app.title"), "Student Management Application", "Hey"));

	}

}
