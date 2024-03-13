package com.jdc.generic.method;

import com.jdc.generic.multi.Pair;

public class Util {
	
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
