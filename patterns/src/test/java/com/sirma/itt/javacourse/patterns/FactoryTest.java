package com.sirma.itt.javacourse.patterns;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.factory.MyClass;
import com.sirma.itt.javacourse.factory.MyClassFactory;

/**
 * Test class for factory design pattern.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class FactoryTest {

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {

		return new Object[][] {{ "Stella", 33 }};
	}
	
	/**
	 * Test getInstance method. Make sure that instance is created.
	 * 
	 */
	@Test
	public void createInstance() {
		MyClass instance = MyClassFactory.createInstance("com.sirma.itt.javacourse.factory.MyClass");
		Assert.assertNotNull(instance);
	}
	
	/**
	 * Test getMyClass method. Make sure that instance is created.
	 * 
	 */
	@Test
	public void getMyClass() {
		MyClass instance = MyClassFactory.getMyClass();
		Assert.assertNotNull(instance);
	}
	
	/**
	 * Test getInstance method. Make sure that instance is created.
	 * 
	 */
	@Test(dataProvider = "validData")
	public void getMyClass(String name, int age) {
		MyClass instance = MyClassFactory.getMyClass(name, age);
		Assert.assertNotNull(instance);
	}
}
