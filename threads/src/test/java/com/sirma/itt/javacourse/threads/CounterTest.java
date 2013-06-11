package com.sirma.itt.javacourse.threads;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.threads.counter.Counter;

/**
 * Test class for Counter.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class CounterTest {

	private Counter counter = new Counter(5);

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { 5 } };
	}

	/**
	 * Test getNumber method.
	 * 
	 * @param valid - valid counter value
	 */
	@Test(dataProvider = "validData")
	public void getNumber(int valid) {
/*		try {
			counter.getThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int value = counter.getNumber();
		Assert.assertEquals(value, valid);*/
	}
}