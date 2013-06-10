package com.sirma.itt.javacoure.singleton;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.observer.TV;

/**
 * Test class for observer design pattern.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class ObserverTest {

	private Hashtable<String, TV> soldOut = new Hashtable<String, TV>(5);
	
	/**
	 * Load all needed data before tests run.
	 */
	@BeforeSuite
	public void fillTestDate() {
		TV beko = new TV("Beko");
		TV LG = new TV("LG");
		TV sony = new TV("Sony");
		
		soldOut.put("", beko);
		soldOut.put("", LG);
		soldOut.put("", sony);
	}
	
	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {

		return new Object[][] {{ soldOut }};
	}
	
	/**
	 * Test getInstance method. Only one instance must be created.
	 * 
	 * @param valid - correct instance
	 */
	@Test(dataProvider = "validData")
	public void add(TV soldTV) {
		TV tv = new TV("LG");
		Assert.assertEquals(tv, soldTV);
	}
}