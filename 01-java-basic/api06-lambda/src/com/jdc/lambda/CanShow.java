package com.jdc.lambda;

@FunctionalInterface
public interface CanShow<T> {

	void show(T data);
	
	@Override
	boolean equals(Object obj);
		
	static void stMethod() {
		System.out.println();
	}
	
	default void dfMethod() {
		System.out.println();
	}
	
}