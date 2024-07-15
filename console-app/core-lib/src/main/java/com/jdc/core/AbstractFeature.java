package com.jdc.core;

public abstract class AbstractFeature {

	private int id;
	private String name;

	public AbstractFeature(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void showMenu() {
		System.out.println("%d. %s".formatted(id, name));
	}
	
	public abstract void doBusiness();

}
