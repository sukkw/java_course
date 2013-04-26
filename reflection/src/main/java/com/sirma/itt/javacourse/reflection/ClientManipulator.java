package com.sirma.itt.javacourse.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Get information for Client class (methods, fields, etc..) using reflection.
 * 
 * @version 1.1 26 April 2013
 * @author Stella Djulgerova
 */
public class ClientManipulator {

	/**
	 * Get information about methods in class
	 * @param client - class we want to get info
	 */
	public void getMethodsInfo(Client client) {

		Class classToReflect = client.getClass();
		// Class classToReflect = Client.class;

		Method[] methods = classToReflect.getDeclaredMethods();
		//Method[] methods = classToReflect.getMethods();
		
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

	}
	
	/**
	 * Get information about fields in class
	 * @param client - class we want to get info
	 */
	public void getFieldsInfo(Client client) {

		Class classToReflect = client.getClass();
		// Class classToReflect = Client.class;

		Field[] fields = classToReflect.getDeclaredFields();
		//Field[] fields = classToReflect.getFields();
		
		for (Field field : fields) {
			getModifier(field.getModifiers());
			System.out.println("Parameter type: " + field.getType());
			System.out.println("Parameter name: " + field.getName());

			//set access to field true and get value
			field.setAccessible(true);
			Object value = null;
			try {
				value = field.get(client);
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
	}

	/**
	 * Get the modifier of method or field (public, private or protected)
	 * @param modifier - modifier as integer value
	 */
	private void getModifier(int modifier) {
		if (Modifier.isPublic(modifier)) {
			System.out.println("Modifier type: Public");
		} else if (Modifier.isPrivate(modifier)) {
			System.out.println("Modifier type: Private");
		} else if (Modifier.isProtected(modifier)) {
			System.out.println("Modifier type: Protected");
		}
	}
	
	/**
	 * Get the type of method (getter or setter)
	 * @param type - mane of the method
	 */
	private void getMethodType(String type) {
		if(type.startsWith("get")) {
			System.out.println("Getter method ");
		} else if(type.startsWith("set")) {
			System.out.println("Setter method ");
		}
	}

}
