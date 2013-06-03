package com.sirma.itt.javacourse.factory;

import com.sirma.itt.javacourse.reflection.ClassCreator;

/**
 * Create instance of MyClass using Factory design pattern.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class MyClassFactory {

	/**
	 * Make instance of myClass using reflection.
	 * @param className
	 * @return
	 */
	public static MyClass createInstance(String className) {
		
		if(className == null) {
			return null;
		}
		
		// try to get class from name
		Class classToReflect = null;
		try {
			classToReflect = Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("Can not create instance!");
			return null;
		}
		
		ClassCreator classCreator = new ClassCreator();
		return  classCreator.makeInstance(classToReflect, null, null);
	}
	
	
	// FactoryMethod
	
	/**
	 * Create instance of myClass.
	 * @return - myClass instance
	 */
	public static MyClass getMyClass() {
		return new MyClass();
	}
	
	/**
	 * Create instance of myClass
	 * @param name - person name
	 * @param age - person age
	 * @return - myClass instance
	 */
	public static MyClass getMyClass(String name, int age) {
		return new MyClass(name, age);
	}
}
