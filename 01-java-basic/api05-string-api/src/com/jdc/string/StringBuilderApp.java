package com.jdc.string;

public class StringBuilderApp {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello");
		sb.append(" JDC");
				
		sb.append("aaaaaaaa");
		
		int capacity = sb.capacity();
		
		System.out.println(sb);
		System.out.println(capacity); // (capacity + 1) * 2
	}
	
}
