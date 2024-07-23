package com.jdc.app;

import java.math.BigDecimal;
import static java.lang.System.out;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

public class MainApp {

	public static void main(String[] args) {
		
		Data.sumArray(new int[] {});
		Data.sumVarargs("", 1);
		
		System.out.println(MIN_VALUE);
		System.out.println(parseInt("10"));
		
		byte byteValue = 10; // -128 127
		short shortValue = 130; // -2^15 to 2^15 - 1
		int intValue = 200; // -2^31 to 2^31 - 1
		long longValue = 300L;
		
		float floatValue = 399;
		double doubleValue = 233;
		
		longValue = (int)floatValue;	
		
		intValue = shortValue; // Implicit cast or up cast
		
		byteValue = (byte) shortValue; // Explicit cast or down cast
		
		out.println(byteValue + intValue + longValue + doubleValue);
		
//		Byte helperByte = 100;
//		Short helperShort = 1300;
//		Integer helperInteger = 2000;
//		Long helperLong = Integer.valueOf(3000);
//		
//		Float helperFloat = 100.0;

		BigDecimal result = new BigDecimal(0);
		for(int i = 0; i < 10; i++) {
			result = result.add(new BigDecimal(0.1));
		}
		
		System.out.println(result);
				
//		priInt = helperInt; // above 5 auto unbox
		
//		helperInt = priInt; // auto box
		
//		helperInt = Integer.valueOf(priInt); // before 5
//		priInt = helperInt.intValue();

	}

}
