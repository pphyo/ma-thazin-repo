package com.jdc.collection.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CollectionUtil {
	
	@Test
	void test3() {
		var emp1 = new Employee("Kyaw Thu", 3000, "09393939", 14);
		var emp2 = new Employee("Adam", 4500, "01939933", 24);
		var emp3 = new Employee("Zack Wilder", 3800, "0233333", 22);
		
		var empList = Arrays.asList(emp1, emp2, emp3);
		
//		var salaryAsc = new Comparator<Employee>() {
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return (int)(o1.getSalary() - o2.getSalary());
//			}
//		};
		
		var salayDesc = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return (int)(o2.getSalary() - o1.getSalary());
			}
		};
		
		empList.sort(salayDesc);
		System.out.println(empList);
		
		var intList = Arrays.asList(4, 7, 5, 3, 2, 1, 29);
		Collections.sort(intList);
		var result = Collections.binarySearch(intList, 6);
		System.out.println(result);
		
	}
	
	@Test
	void test2() {
		var list = new ArrayList<String>(List.of("Kyaw Kyaw", "Nyi Nyi", "Aung Min", "Bo Naing"));
		
		System.out.println("Before sort: " + list);
		
		Comparator<String> desc = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};
		
		Collections.sort(list, desc);
		
		System.out.println("After sort: " + list);
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			String ele = itr.next();
			if(ele.startsWith("K"))
				itr.remove();
		}
		
		System.out.println(list);
		
//		for(var ele : list) {
//			if(ele.startsWith("K")) {
//				list.remove(ele);
//			}
//		}
		
	}
	
	@Test
	@Disabled
	void test() {
		var arrayList = new ArrayList<Integer>();
		Collections.addAll(arrayList, 1, 2, 3, 4, 5);
		arrayList.add(6);
		System.out.println(arrayList.hashCode());
		
		// do not allow add and remove operation but allow update operation
		var asList = Arrays.asList(1, 2, 3, 4, 5, 6);
		asList.set(2, 7);
		System.out.println(asList.hashCode());
		
		// do not allow all update operation
		var of = List.of(1, 2, 3, 4);
		System.out.println(of.hashCode());
		
		// do not allow all update operation
		var imutColl = Collections.unmodifiableList(arrayList);
		System.out.println(imutColl.hashCode());
		imutColl.set(1, 200);
				
	}

}
