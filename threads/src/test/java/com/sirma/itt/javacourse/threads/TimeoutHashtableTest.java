package com.sirma.itt.javacourse.threads;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.threads.hash.TimeoutHashtable;

/**
 * Test class for TimeoutHashtable.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class TimeoutHashtableTest {

	private Hashtable<String, Object> table;
	private TimeoutHashtable tbl = new TimeoutHashtable();

	/**
	 * Data used for put in hashtable tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validPutData() {
		Hashtable<String, Object> table = new Hashtable<String, Object>(5);
		table.put("4", "test4");
		return new Object[][] { { table } };
	}

	/**
	 * Data used for get from hashtable tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validGetData() {
		return new Object[][] { { "test2" } };
	}

	/**
	 * Test put method.
	 * 
	 * @param valid
	 *            - correct value
	 */
	@Test(dataProvider = "validPutData")
	public void put(Hashtable<String, Object> valid) {

		try {
			Field f = tbl.getClass().getDeclaredField("table");
			f.setAccessible(true);
			tbl.put("4", "test4");
			Hashtable value = (Hashtable) f.get(tbl);
			f.setAccessible(false);
			Assert.assertEquals(value, valid);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test get method.
	 * 
	 * @param valid
	 *            - correct value
	 */
	@Test(dataProvider = "validGetData")
	public void get(String valid) {
		tbl.put("1", "test1");
		tbl.put("2", "test2");
		tbl.put("3", "test3");
		String value = (String) tbl.get("2");
		Assert.assertEquals(value, valid);
	}
}