package com.jdc.generic.method;

import java.util.List;

import com.jdc.generic.multi.Pair;

public class Util {
	
	public static void printList(List<?> list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
	
	public static double sumOfList(List<? extends Number> list) {
		double sum = 0;
		for(Number n : list) {
			sum += n.doubleValue();
			System.out.println(n.getClass().getName());
		}
		return sum;
	}
	
	public static <T> T pick(T a1, T a2) { 
		return a2;
	}
	
	public static <T extends Comparable<T>> int countGreaterThan(T[] array, T ele) {
		int count = 0;
		for(T e : array) {
			if(e.compareTo(ele) > 0) {
				count ++;
			}
		}
		
		return count;
	}
	
	public <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean isEqualKey = p1.getKey().equals(p2.getKey());
		boolean isEqualValue = p1.getValue().equals(p2.getValue());
		
		return isEqualKey && isEqualValue;
	}
	
}
