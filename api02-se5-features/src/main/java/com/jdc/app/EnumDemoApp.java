package com.jdc.app;

public class EnumDemoApp {
	
//	private static final int SUN = 0;
//	private static final int MON = 1;

	public static void main(String[] args) {
		afterEnum();
	}
	
	public static void afterEnum() {
//		Course se = Course.JavaSE;
//		Course value = se;
//		System.out.println(Arrays.toString(Course.values()));
//		System.out.println(se.ordinal());
//		System.out.println(se.name());
		
		Course[] array = Course.values();
		
//		int i;
//		
//		for(i = 0; i < array.length; i++) {
//			System.out.println("%d: %s".formatted(array[i].ordinal(), array[i].name()));
//		}
		
		for(Course course : array) {
			System.out.println("%d : %s : %s : %.2f"
					.formatted(course.ordinal(), 
							course.name(), 
							course.getCourseName(),
							course.getFees()));
		}
	}
	
	public static String beforeEnum(final int code) {
		int value = code;
		value = 10;
		return switch(value) {
			case 0: { yield "Sunday"; }
			case 1: { yield "Monday"; }
			default: { throw new IllegalArgumentException(); }
		};
	}
	
}
