package com.jdc.lambda;

public class LambdaApplication {
	
	public LambdaApplication() {
		System.out.println("Default");
	}
	
	public LambdaApplication(int i) {
		System.out.println("Int constructor: " + i);
	}
	
	public LambdaApplication(String i) {
		System.out.println("String constructor: " + i);
	}

	public static void main(String[] args) {
		
//		LambdaApplication mainApp = new LambdaApplication();
//		mainApp.run();
		
		CanShow<Integer> csInt = LambdaApplication::new;
		csInt.show(10);
		
		CanShow<String> csString = LambdaApplication::new;
		csString.show("Hello");
		
	}
	
	void run() {
		CanShow<Integer> instToInst = this::displayForInstance;
		instToInst.show(20);
	}
	
	// create instance when static context use from instance
	// instance context uses both instance members and static members
	static void runForCanShowWithMF() {
		CanShow<Integer> csForStatic = LambdaApplication::displayForStatic;
		csForStatic.show(10);
		
		LambdaApplication app = new LambdaApplication();
		CanShow<Integer> csForInstance = app::displayForInstance;
		csForInstance.show(20);
	}
	
	static void displayForStatic(int i) {
		System.out.println("Static Display: " + i);
	}
	
	void displayForInstance(int i) {
		System.out.println("Instance Display: " + i);
		this.display();
	}
	
	void display() {
		System.out.println("Another display");
	}
	
	static void runForCanCalculate() {
		CanCalculate cal = (a, b) -> a + b;
		System.out.println(cal.calculate(3, 4));
	}
	
//	static void runForCanShow() {
//		CanShow cs = a -> System.out.println(a);
//		
//		cs.show("This one parameter SAM.");
//	}
	
	static void runWithSubClass() {
		Runnable run = new RunnableImpl();
		Thread t = new Thread(run);
		t.run();
	}
	
	static void runWithAnonymousClass() {
		int i = 10;
		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable from anonymous class." + i);				
			}
		};

		var t = new Thread(run);
		t.run();
	}
	
	static void runWithLambda() {
		Runnable task = () -> System.out.println("Runnable from anonymous class.");
		Thread t = new Thread(task);
		t.start();
	}

}

class RunnableImpl implements Runnable {
	@Override
	public void run() {
		System.out.println("Runnable from RunnableImpl.");	
	}
	
	static void stMethod() {}
}
