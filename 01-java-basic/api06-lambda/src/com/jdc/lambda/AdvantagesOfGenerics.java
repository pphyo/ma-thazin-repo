package com.jdc.lambda;

import java.util.List;
import java.util.function.Predicate;

public class AdvantagesOfGenerics {
	
	public static void main(String[] args) {
		List<Fruit> fruits = List.of(
				new Fruit("Apple", "Green", 0.2),
				new Fruit("Banana", "Yellow", 0.1),
				new Fruit("Grape", "Purple", 0.5),
				new Fruit("Orange", "Orange", 0.23),
				new Fruit("Apple", "Red", 0.14),
				new Fruit("Banana", "Green", 0.24),
				new Fruit("Mango", "Yellow", 0.34),
				new Fruit("Dragon Fruit", "Red", 0.45)
				);
		
		Predicate<Fruit> colorPred = f -> f.color() == "Yellow";
		
		Predicate<Fruit> weightPred = f -> f.weight() > 0.20;
		
		showList(fruits, weightPred.and(colorPred));
		
	}
	
	@SuppressWarnings("all")
	static <T extends Fruit> void showList(List<T> list, Predicate<T> pred) {
		for(T t : list) {
			if(pred.test(t))
				System.out.println(t);
		}
	}

}
