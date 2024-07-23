package com.jdc.converter;

import com.jdc.converter.domain.User;
import com.jdc.converter.support.JsonConverter;

public class JsonConverterApp {

	public static void main(String[] args) {
		try {
			var user = new User();
			user.setUsername("Pyae Phyo");
			user.setEmail("pyaephyo.jdc@gmail.com");
			user.setPassword("pyaephyo");
			user.setPhone("0943939393");
			user.setGrade('A');
			user.setAge(25);
			
			var converter = new JsonConverter();
			var result = converter.convertToJson(user);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
