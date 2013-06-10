package com.sirma.itt.javacourse.threads;

import java.lang.reflect.Field;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.threads.warehouse.Warehouse;

/**
 * Test class for warehouse methods.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class WarehouseTest {
	
	private Warehouse warehouse = new Warehouse();
	
	/**
	 * Data used for remove stock tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validRemoveData() {
		return new Object[][] { { 7 }};
	}
	
	/**
	 * Data used for add stock tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validAddData() {
		return new Object[][] { { 19 }};
	}

	/**
	 * Test putStock method.
	 * 
	 * @param valid - correct value
	 */
	@Test(dataProvider = "validRemoveData")
	public void getStock(int valid) {

		try {
			
			Field f = warehouse.getClass().getDeclaredField("productionCounter");
			f.setAccessible(true);
			f.set(warehouse, 12);
			warehouse.getStock(5);
			int value = (int) f.get(warehouse);
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
	 * Test putStock method.
	 * 
	 * @param valid - correct value
	 */
	@Test(dataProvider = "validAddData")
	public void putStock(int valid) {

		try {
			warehouse.putStock(12);
			Field f = warehouse.getClass().getDeclaredField("productionCounter");
			f.setAccessible(true);
			int value = (int) f.get(warehouse);
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
}