package com.jdc.collection.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListInterfaceTest {
	
	List<Integer> arrayList;
	LinkedList<Integer> linkedList = new LinkedList<>();
	
	@BeforeEach
	void setUpBeforeClass() {
		arrayList = Arrays.asList(10, 4, 7, 2, 6, 8, 3, 1, 5, 9);
		Collections.addAll(linkedList, 10, 4, 7, 2, 6, 8, 3, 1, 5, 9);
	}
	
	@Test
	void test_for_arrayList() {
		var otherList = new ArrayList<Integer>();
		Collections.addAll(otherList, 7, 5, 3, 8, 4, 6);
		
		arrayList.add(5, 9);
		arrayList.addFirst(7);
		arrayList.addAll(2, otherList);
		
		assertEquals(10, arrayList.get(1));
		
		arrayList.set(2, 17);
		
		arrayList.remove(0);
		arrayList.remove(Integer.valueOf(100));
		
		arrayList.indexOf(7);
		
		System.out.println(arrayList);
		
		arrayList.clear();
		
		assertEquals(0, arrayList.size());
		
		assertThrows(NoSuchElementException.class, () -> arrayList.removeFirst());
		assertThrows(NoSuchElementException.class, () -> arrayList.removeLast());
		
		
	}

}
