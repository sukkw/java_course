package com.sirma.itt.javacourse.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Make instance of class using reflection.
 * 
 * @version 1.1 26 April 2013
 * @author Stella Djulgerova
 */
public class ClassCreator {

	/**
	 * Create instance of class using reflection.
	 * 
	 * @param className - name of the class 
	 * @param params - class constructor parameters (or null)
	 * @param values - value for each parameter (or null)
	 */
	public void makeInstance(String className, Class[] params, Object[] values) {

		// try to get class from name
		Class classToReflect = null;
		try {
			classToReflect = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		makeInstance(classToReflect, params, values);
		
		System.out.println("Class: " + classToReflect.getName());
		System.out.println("Extends: " + classToReflect.getSuperclass());

		Class[] interfaces = classToReflect.getInterfaces();

		for (Class interfc : interfaces) {
			System.out.println("Implements: " + interfc.getName());
		}
	}

	/**
	 * Create class instance.
	 * 
	 * @param classToReflect - class to be instantiated
	 * @param params - class constructor parameters (or null)
	 * @param values - value for each parameter (or null)
	 * @return class instance
	 */
	public Object makeInstance(Class classToReflect, Class[] params, Object[] values) {
		Constructor constructor = null;
		Object classInstance = null;
		try {
			constructor = classToReflect.getConstructor(params);
			classInstance = constructor.newInstance(values);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return classInstance;
	}
}
