package com.jdc.converter.support;

import java.lang.reflect.Field;
import java.util.Objects;

import com.jdc.converter.domain.Json;
import com.jdc.converter.domain.JsonException;
import com.jdc.converter.domain.JsonField;
import com.jdc.converter.domain.User;

public class JsonConverter {
	
	public String convertToJson(User user) throws IllegalAccessException {
		checkUser(user);
		return getJson(user);
	}
	
	
	private String getJson(User user) throws IllegalArgumentException, IllegalAccessException {
		String[] keys = new String[5];
		Object[] values = new Object[5];
		
		var fields = user.getClass().getDeclaredFields();
		
		var counter = 0;
		
		for(var field : fields) {
			if(field.isAnnotationPresent(JsonField.class)) {
				field.setAccessible(true);
				keys[counter] = getKey(field);
				values[counter] = getValue(field, user);
				counter ++;
			}
		}
		
		StringBuilder sb = new StringBuilder("{\n");
		
		for(int i = 0; i < keys.length; i++) {
			sb.append("\t");
			sb.append("\"%s\": ".formatted(keys[i]));
			sb.append(values[i]);
			if(keys.length - 1 != i) {
				sb.append(",\n");
			}
		}
		
		sb.append("\n}");
		
		return sb.toString();
	}
	
	private Object getValue(Field field, User user) throws IllegalAccessException {
		if(isEqualsClass(field, String.class) || isEqualsClass(field, Character.class) || isEqualsClass(field, char.class)) {
			return "\"%s\"".formatted(field.get(user));
		}
		return field.get(user);
	}
	
	private boolean isEqualsClass(Field field, Class<?> type) {
		return field.getType().equals(type);
	}
	
	private String getKey(Field field) {
		String name = field.getAnnotation(JsonField.class).name();
		return name.isEmpty() ? field.getName() : name;
	}
	
	private void checkUser(User user) {
		if(Objects.isNull(user)) {
			throw new JsonException("Null object can't convert to json!");
		}
		
		if(!user.getClass().isAnnotationPresent(Json.class)) {
			throw new JsonException(
					"%s not annotated with @Json"
					.formatted(user.getClass().getName()));
		}
	}

}
