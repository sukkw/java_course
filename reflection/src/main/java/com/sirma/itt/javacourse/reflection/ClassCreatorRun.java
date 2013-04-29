package com.sirma.itt.javacourse.reflection;

/**
 * Class creator run class.
 * 
 * @version 1.1 26 April 2013
 * @author Stella Djulgerova
 */
public class ClassCreatorRun {

	public static void main(String[] args) {

		ClassCreator classCreator = new ClassCreator();

		String className = "com.sirma.itt.javacourse.reflection.Client";
		// String name = "java.lang.String";

		Class[] params = null;
		Object[] values = null;
		
		//params = new Class[] {String.class };
		//values = new Object[] { "Stella" };
		 
		classCreator.makeInstance(className, params, values);
	}
}
