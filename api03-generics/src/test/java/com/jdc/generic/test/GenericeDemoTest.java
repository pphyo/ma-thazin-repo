package com.jdc.generic.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Vector;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.generic.Box;
import com.jdc.generic.GenericBox;
import com.jdc.generic.NonGenericBox;
import com.jdc.generic.method.Util;
import com.jdc.generic.multi.OrderedPair;
import com.jdc.generic.multi.Pair;

public class GenericeDemoTest {
	
	@Test
	void test_for_subtype_inheritance() {
		
		Box<Number> numBox = new Box<>();
		numBox.setData(Integer.valueOf(10));
		numBox.setData(Double.valueOf(20.0));
		
	}
	
	@Test
	void test_for_bounded_type_generic_method() {
		var intCompare = Util.countGreaterThan(new Integer[] {1, 2, 3, 4, 5}, 2);
		assertEquals(3, intCompare);
		
		var strCompare = Util.countGreaterThan(new String[] {"a", "b", "bc", "A", "B"}, "b");
		assertEquals(1, strCompare);
		
		
	}
	
	@Test
	void test_for_generic_method() {
		Pair<String, Integer> p1 = new OrderedPair<>("One", 1);
		Pair<String, Integer> p2 = new OrderedPair<>("One", 1);
		Pair<String, Integer> p3 = new OrderedPair<>("Two", 1);
		
		assertTrue(new Util().<String, Integer>compare(p1, p2));
		assertFalse(new Util().compare(p1, p3));
	}
	
	@Test
	@Disabled
	void test_for_raw_types() {
//		GenericBox<Integer> gBox = new GenericBox<Integer>();
//		// generic type to raw type
//		GenericBox rawBox = gBox;
//		
//		rawBox.setData(new Date());
//		
//		System.out.println(rawBox.getData());
		
		GenericBox rawBox2 = new GenericBox();
		GenericBox<Integer> gBox2 = rawBox2;
	}
	
	@Test
	void test_for_multi_types() {
		
		Pair<Integer, Object> intObjPair = new OrderedPair<>(null, null);
		
//		Pair<String, Integer> strIntPair1 = new OrderedPair<>("One", 1);
//		Pair<String, Integer> strIntPair2 = new OrderedPair<>("Two", 2);
//		
//		Pair<String[], Integer[]> strIntArrPair = 
//				new OrderedPair<>(new String[] {"a", "b", "c"}, new Integer[] {1, 2, 3});
//		
//		KeyStringValuePair<Date> keyStringPair = new KeyStringValuePair<Date>();
//		
//		Pair<Integer, Integer> intIntPair = new IntIntPair();
		
	}
	
	@Test
	@Disabled
	void test_for_generic_types() {
		var ngBox = new NonGenericBox();
		ngBox.setObject(1);
		
		GenericBox<Integer> gBox = new GenericBox<Integer>();
		gBox.setData(100);
		assertEquals(100, gBox.getData());
	}
	
	@Test
	@Disabled
	void test_for_generic() {
		Vector<Integer> intVector = new Vector<>();
		intVector.add(10);
		intVector.add(20);
//		intVector.add("");
		
		for(Integer intData : intVector) {
			System.out.println(intData);
		}
	}
	
	@Test
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Disabled
	void test_for_non_generic() {
		Vector list = new Vector();
		list.add(10);
		list.add("Hello Vector");
		list.add(new Date());
		
		assertThrows(ClassCastException.class, () -> {
			System.out.println((Integer) list.get(1));
		});
		
		assertThrows(ClassCastException.class, () -> {
			System.out.println((Integer) list.get(2));
		});
	}

}






