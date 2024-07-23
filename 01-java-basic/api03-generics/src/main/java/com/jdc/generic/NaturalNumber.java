package com.jdc.generic;

class SuperClazzA {}
class ClazzA extends SuperClazzA {}
class SubClazzA extends ClazzA {}

class ClazzB {}
interface InterfaceC {}
interface InterfaceD {}

class ClazzE<T extends ClazzA & InterfaceC & InterfaceD> {}

public class NaturalNumber<T extends Integer> {
	
	private T num;

	public NaturalNumber(T num) {
		super();
		this.num = num;
	}
	
	public boolean isEven() {
		return num.intValue() % 2 == 0;
	}

}
