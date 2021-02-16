package com.pattern.factory;

public class Dog implements Pet {

	private String name;
	private boolean isFed = false;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public boolean isHungery() {
		// TODO Auto-generated method stub
		return !this.isFed;
	}
	public void feed() {
		this.isFed = true;
	}
}
