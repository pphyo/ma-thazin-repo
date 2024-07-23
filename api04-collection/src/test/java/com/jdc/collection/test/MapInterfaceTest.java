package com.jdc.collection.test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapInterfaceTest {
	
	TreeMap<String, String> map = new TreeMap<>();
	
	@BeforeEach
	void setUp() {
		map.put("Myanmar", "Yangon");
		map.put("Korea", "Souel");
		map.put("Thai", "Bangkok");
		map.put("Philippine", "Manila");
		map.put("Indonesia", "Jakarta");
	}
	
	@Test
	void test() {
		Set<String> keys = map.keySet();
		Collection<String> values = map.values();

		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		System.out.println(keys);
		System.out.println(values);
		
		for(var entry : entrySet) {
			if(entry.getKey() == "Myanmar") {
				System.out.println(entry.setValue("Naypyidaw"));
			}
			System.out.println("%s : %s".formatted(entry.getKey(), entry.getValue()));
		}
	}

}
