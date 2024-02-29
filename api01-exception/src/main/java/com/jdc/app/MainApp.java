package com.jdc.app;

public class MainApp {

	public static void main(String[] args) {
		try {
			User user = new User();
			user.setUsername("pphyo");
//			user.setPassword("pyaephyo");
			Validators.check(user);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error", e);
		}
	}

}
