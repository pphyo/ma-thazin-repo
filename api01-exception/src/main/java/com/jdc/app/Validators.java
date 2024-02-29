package com.jdc.app;

import java.util.Objects;

public class Validators {
	
	public static void check(User user) {
		if(Objects.isNull(user)) {
			throw new AppException("User can't be empty!", new RuntimeException("User is null!"));
		}
		
		if(user.getUsername() == null) {
			throw new AppException("Please provide username!", new RuntimeException("Username is null!"));
		}
		
		if(user.getPassword() == null) {
			throw new AppException("Please provide password!");
		}
	}

}
