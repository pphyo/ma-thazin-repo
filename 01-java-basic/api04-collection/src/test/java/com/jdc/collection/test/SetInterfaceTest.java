package com.jdc.collection.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SetInterfaceTest {
	
	@Test
	void test_for_setUtil() {
		var set = new LinkedHashSet<Integer>();
		Collections.addAll(set, 3, 7, 8, 9, 1, 2, 6, 4);
		
		set.remove(100);
	}
	
	@Test
	@Disabled
	void test_for_treeSet() {
		TreeSet<Integer> set = new TreeSet<>();
		Collections.addAll(set, 3, 7, 8, 9, 1, 2, 6, 4);
		
		System.out.println("Sub set: " + set.subSet(3, false, 7, true));
		System.out.println("Head set: " + set.headSet(4, false));
		System.out.println("Tail set: " + set.tailSet(6, false));
		
		System.out.println("Poll first: " + set.pollFirst());
		System.out.println("First: " + set.first());
		System.out.println("Last: " + set.last());
		System.out.println("Floor: " + set.floor(5));
		System.out.println("Ceiling: " + set.ceiling(9));
		
		System.out.println("Higher: " + set.higher(10));
		System.out.println("Lower: " + set.lower(5));
		
		set.addFirst(-1);
		
		System.out.println(set.descendingSet());
	}
	
	@Test
	@Disabled
	void test_for_hashSet() {
		Set<Integer> set = new HashSet<>();
		
		// add
		assertTrue(set.add(5));
		assertTrue(set.add(8));
		assertTrue(set.add(3));
		assertTrue(set.add(9));
		assertFalse(set.add(3));
		assertTrue(set.add(null));
		
		assertEquals(5, set.size());
		assertFalse(set.isEmpty());
		
		assertTrue(set.add(1));
		assertTrue(set.add(7));
		
		assertEquals(7, set.size());
		
		// remove
		assertTrue(set.remove(3));
		assertFalse(set.remove(2));
		assertTrue(set.remove(null));
		assertFalse(set.remove(null));
		
		assertEquals(5, set.size());
		
		// contain
		assertTrue(set.contains(7));
		assertFalse(set.contains(2));
		
		Set<Integer> otherSet = new HashSet<>();
		Collections.addAll(otherSet, 10, 11, 1, 5, 7, 9);
		
		// remove All
		System.out.println(set.removeAll(otherSet));
		System.out.println(set.removeAll(otherSet));
		
	
		System.out.println("Other Set: " + otherSet);
		System.out.println("Original Set: " + set);
	}

}
