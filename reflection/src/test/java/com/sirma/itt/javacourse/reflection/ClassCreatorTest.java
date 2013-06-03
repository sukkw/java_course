package com.sirma.itt.javacourse.reflection;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for ClassCreator methods.
 * 
 * @version 1.1 29 April 2013
 * @author Stella Djulgerova
 */
public class ClassCreatorTest {

	// class private members
	private ClassCreator creator = new ClassCreator();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {

		return new Object[][] { { "com.sirma.itt.javacourse.reflection.Client", null, null},
				{ "com.sirma.itt.javacourse.reflection.Client", new Class[] {String.class }, new Object[] { "test" } }};
	}
	
	/**
	 * Test makeInstance method.
	 * 
	 * @param className - class to be instantiated
	 * @param params - class constructor parameters (or null)
	 * @param values - value for each parameter (or null)
	 */
	@Test(dataProvider = "validData")
	public void makeInstance(String className, Class[] params, Object[] values) {
		
		// try to get class from name
		Class classToReflect = null;
		try {
			classToReflect = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		Object result = creator.makeInstance(classToReflect, params, values);

		Assert.assertTrue(result instanceof Client);
	}
}
