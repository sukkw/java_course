package com.sirma.itt.javacourse.patterns;

import java.lang.reflect.Field;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.pool.DataClass;
import com.sirma.itt.javacourse.pool.Pool;
import com.sirma.itt.javacourse.pool.PoolException;

/**
 * Test class for pool design pattern.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class PoolTest {

	private Pool pool = new Pool(3);
	private List<DataClass> instancesList;
	private DataClass element;

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {

		try {
			Field f = pool.getClass().getDeclaredField("instancesList");
			f.setAccessible(true);
			instancesList = (List<DataClass>) f.get(pool);
			f.setAccessible(false);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		element = instancesList.get(2);
		return new Object[][] { { element } };
	}

	/**
	 * Test acquire method.
	 * 
	 * @param element - element which must be acquired from pool
	 */
	@Test(dataProvider = "validData")
	public void acquire(DataClass validElement) {
		try {
			DataClass element = pool.acquire();
			Assert.assertEquals(element, validElement);
		} catch (PoolException e) {
			System.err.println(e.getMessage());
		}
	}
}