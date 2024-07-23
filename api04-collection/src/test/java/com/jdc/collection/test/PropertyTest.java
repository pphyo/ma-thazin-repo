package com.jdc.collection.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PropertyTest {
	
	static final Properties prop = new Properties();
	
	@BeforeAll
	static void init() {
		try {
			prop.load(new FileInputStream("src/test/resources/app.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test2() {
		System.out.println(prop.get("app.author"));
	}
	
	@Test
	@Disabled
	void test() {
		
		try {
			Properties props = System.getProperties();
			props.list(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
