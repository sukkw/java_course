package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for exception message manager methods.
 * 
 * @version 1.1 10 May 2013
 * @author Stella Djulgerova
 */
public class ExceptionManagerTest {

	private Map<String, String> exceptions = new HashMap<String, String>();
	ExceptionsMessageManager excManager;
	
	/**
	 * Load all needed test data before tests run.
	 */
	@BeforeSuite
	public void fillTestDate() {
		// map is filled with different exceptions
		exceptions.put("Exception1", "Invalid Debit Card Number");
		exceptions.put("Exception2", "Invalid Post Code");
		exceptions.put("Exception3", "Invalid Phone Number");
		exceptions.put("Exception4", "Invalid E-mail");
	}
	
	/**
	 * Data used for add exception message by value test.
	 * 
	 * @return object with data used for add exception message by value
	 */
	@DataProvider
	public Object[][] validValueData() {
		excManager = new ExceptionsMessageManager(exceptions);
		return new Object[][] { {"Invalid Post Code", "Invalid Post Code"},
				{"Invalid E-mail", "Invalid Post Code|Invalid E-mail"}};
	}
	
	/**
	 * Data used for add exception message by key test.
	 * 
	 * @return object with data used for add exception message by key
	 */
	@DataProvider
	public Object[][] validKeyData() {
		excManager = new ExceptionsMessageManager(exceptions);
		return new Object[][] { {"Exception2", "Invalid Post Code"},
				{"Exception4", "Invalid Post Code|Invalid E-mail"}};
	}
	
	/**
	 * Data used for get messages test.
	 * 
	 * @return object with data used for get messages test
	 */
	@DataProvider
	public Object[][] validMessagesData() {
		Collection<String> massageList = new ArrayList<String>();

		massageList.add("Invalid Post Code");
		massageList.add("Invalid E-mail");
		return new Object[][] { {"Invalid Post Code|Invalid E-mail", 
			massageList}};
	}
	
	/**
	 * Test add exception by value method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validValueData")
	public void testAddExceptionMessage(String message, String valid) {

		try {
			excManager.addExceptionMessage(message);
			Assert.assertEquals(excManager.getMessage(), valid);

		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test add exception by key method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validKeyData")
	public void testAddExceptionMessageUsingCode(String message, String valid) {

		try {
			excManager.addExceptionMessageUsingCode(message);
			Assert.assertEquals(excManager.getMessage(), valid);
			
		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test get messages method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validMessagesData")
	public void testGetMessages(String message, Collection<String> valid) {
		Collection<String> result = ExceptionsMessageManager.getMessages(message);
		Assert.assertTrue(result.equals(valid));
	}
}
