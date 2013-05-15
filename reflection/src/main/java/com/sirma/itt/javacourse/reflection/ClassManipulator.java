package com.sirma.itt.javacourse.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Get information for class (methods, fields, etc..) using reflection.
 * 
 * @version 1.1 26 April 2013
 * @author Stella Djulgerova
 */
public class ClassManipulator {

	/**
	 * Get information about methods in class.
	 * 
	 * @param classInstance - class we want to get info
	 */
	public void getMethodsInfo(Object classInstance) {

		Class classToReflect = classInstance.getClass();

		getConstructorsInfo(classToReflect);
		getMethodsInfo(classToReflect);
	}

	/**
	 * Get information about fields in class.
	 * 
	 * @param classInstance - class we want to get info
	 * @return array with fields in class
	 */
	public Field[] getFieldsInfo(Object classInstance) {

		Class classToReflect = classInstance.getClass();

		Field[] fields = classToReflect.getDeclaredFields();

		for (Field field : fields) {
			getModifier(field.getModifiers());
			System.out.println("Parameter type: " + field.getType());
			System.out.println("Parameter name: " + field.getName());
			Object value = null;
			
			try {
				// set access to field true and get value
				field.setAccessible(true);
				value = field.get(classInstance);
				
				// set access to false and protect field
				field.setAccessible(false);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			if (value != null) {
				System.out.println("Parameter value: " + value);
			}

			System.out.println();
		}
		return fields;
	}

	/**
	 * Get information about class constructors.
	 * 
	 * @param classToReflect - class inspected with reflection
	 * @return array with all class constructors
	 */
	public Constructor[] getConstructorsInfo(Class classToReflect) {

		Constructor[] constructors = classToReflect.getConstructors();

		for (Constructor construct : constructors) {

			System.out.println("Constructor name: " + construct.getName());
			getModifier(construct.getModifiers());

			Class[] parameters = construct.getParameterTypes();
			System.out.println("Parameters: ");
			for (Class param : parameters) {
				System.out.println(param.getName());
			}
			System.out.println();
		}
		return constructors;
	}
	
	/**
	 * Get information about class methods.
	 * 
	 * @param classToReflect - class inspected with reflection
	 * @return array with all class methods
	 */
	public Method[] getMethodsInfo(Class classToReflect) {
		Method[] methods = classToReflect.getDeclaredMethods();
		// Method[] methods = classToReflect.getMethods();

		for (Method method : methods) {
			System.out.println("Method name: " + method.getName());

			getModifier(method.getModifiers());
			getMethodType(method.getName());

			System.out.println("Return type: " + method.getReturnType());

			Class[] parameters = method.getParameterTypes();
			System.out.println("Parameters: ");
			for (Class param : parameters) {
				System.out.println(param.getName());
			}
			System.out.println();
		}
		return methods;
	}

	/**
	 * Get the modifier of method or field (public, private or protected).
	 * 
	 * @param modifier - modifier as integer value
	 */
	private int getModifier(int modifier) {
		if (Modifier.isPublic(modifier)) {
			System.out.println("Modifier type: Public");
		} else if (Modifier.isPrivate(modifier)) {
			System.out.println("Modifier type: Private");
		} else if (Modifier.isProtected(modifier)) {
			System.out.println("Modifier type: Protected");
		}
		return modifier;
	}

	/**
	 * Get the type of method (getter or setter).
	 * 
	 * @param type - mane of the method
	 */
	private void getMethodType(String type) {
		if (type.startsWith("get")) {
			System.out.println("Getter method ");
		} else if (type.startsWith("set")) {
			System.out.println("Setter method ");
		}
	}
}
