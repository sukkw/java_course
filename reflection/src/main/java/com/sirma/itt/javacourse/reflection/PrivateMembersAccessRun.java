package com.sirma.itt.javacourse.reflection;

/**
 * PrivateMembersAccess run class
 * 
 * @version 1.1 26 April 2013
 * @author Stella Djulgerova
 */
public class PrivateMembersAccessRun {

	public static void main(String[] args) {
		ClassCreator classCreator = new ClassCreator();

		String className = "com.sirma.itt.javacourse.reflection.Client";
		// String name = "java.lang.String";

		Class[] params = null;
		Object[] values = null;
		
		params = new Class[] {String.class };
		values = new Object[] { "Stella" };
		 
		PrivateMembersAccess access = new PrivateMembersAccess();
		access.createInstance(className, params, values);
	}
}
