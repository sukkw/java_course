package com.sirma.itt.javacourse.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Make instance of class using reflection and access all private fields and methods.
 * 
 * @version 1.1 26 April 2013
 * @author Stella Djulgerova
 */
public class PrivateMembersAccess {

	ClassCreator creator = new ClassCreator();
	ClassManipulator manipulator = new ClassManipulator();

	/**
	 * Create instance of class using reflection.
	 * 
	 * @param className - name of the class 
	 * @param params - class constructor parameters (or null)
	 * @param values - value for each parameter (or null)
	 */
	public void createInstance(String className, Class[] params, Object[] values) {
		
		Class classToReflect = null;
		try {
			classToReflect = Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("Invalid class name");
			return;
		} catch (NullPointerException e) {
			System.out.println("Invalid class name");
			return;
		}

		Object instance = creator.makeInstance(classToReflect, params, values);

		System.out.println();
		manipulator.getFieldsInfo(instance);

		String methodName = "calculateOrderVal";
		Class[] methodParams = null;
		Object[] methodValues = null;
		callPrivateMethods(classToReflect, instance, methodName, methodParams, methodValues);

		methodName = "orderInfo";
		methodParams = new Class[] { int.class, String.class };
		methodValues = new Object[] { 10, "test" };
		callPrivateMethods(classToReflect, instance, methodName, methodParams, methodValues);
	}

	/**
	 * Call class private methods.
	 * 
	 * @param classToReflect - class taken with reflection
	 * @param instance - instance of the class
	 * @param name - name of the private method we want to access
	 * @param params - array with parameters of the private method
	 * @param values - array with value for each parameter
	 */
	public void callPrivateMethods(Class classToReflect, Object instance, String name,
			Class[] params, Object[] values) {
		Method method = null;
		try {
			method = classToReflect.getDeclaredMethod(name, params);
			method.setAccessible(true);
			method.invoke(instance, values);
			method.setAccessible(false);
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
	}
}
