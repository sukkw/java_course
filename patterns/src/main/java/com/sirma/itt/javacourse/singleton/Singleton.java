package com.sirma.itt.javacourse.singleton;

/**
 * Realize singleton design pattern - only a single instance 
 * of the class can be created .
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class Singleton {

	private static Singleton instance = null;
	
	/**
	 * Constructor. Make constructor private to avoid instantiating.
	 */
	private Singleton() {
		System.out.println("Singleton is created");
	}

	/**
	 * Get instance of the class. Must be synchronized if use threads.
	 * @return instance of class
	 */
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		} 
		return instance;
	}

	/**
	 * Override clone method to avoid make another instance using clone.
	 * {@inheritDoc}
	 */
	public Object clone() throws CloneNotSupportedException {
		System.out.println("Clone is not allowed!!");
		throw new CloneNotSupportedException();
	}
}
