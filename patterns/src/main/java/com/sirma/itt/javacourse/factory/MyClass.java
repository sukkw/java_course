package com.sirma.itt.javacourse.factory;

/**
 * Contain information for person. Name and age
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class MyClass {

	// class private members
	private String name;
	private int age;

	/**
	 * Constructor.
	 * 
	 * @param name - person name
	 * @param age - person age
	 */
	public MyClass(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("My class object is created.");
		System.out.println("name: " + name + " age: " + age);
	}

	/**
	 * Class default constructor.
	 */
	public MyClass() {
		System.out.println("Default my class object is created.");
	}

	/**
	 * Get person name.
	 * 
	 * @return person name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Person name.
	 * 
	 * @param name - person name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get person age.
	 * 
	 * @return person age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set Person age.
	 * 
	 * @param name - person age
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
