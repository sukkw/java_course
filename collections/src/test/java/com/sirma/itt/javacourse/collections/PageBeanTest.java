package com.sirma.itt.javacourse.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for page bean methods.
 * 
 * @version 1.1 10 May 2013
 * @author Stella Djulgerova
 */
public class PageBeanTest {
	
	private PageBean pages;
	
	/**
	 * Load all needed test data before tests run.
	 */
	@BeforeSuite
	public void fillTestDate() {
		Path path = Paths.get("test.txt");
		List<String> lines = new ArrayList<String>();
		String line = null;
		
		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		pages = new PageBean(3, lines);
	}
	
	/**
	 * Data used for get pages test.
	 * 
	 * @return object with data used for get pages test
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { {5}};
	}
	
	/**
	 * Data used for get first page test.
	 * 
	 * @return object with data used for get first page test
	 */
	@DataProvider
	public Object[][] validFPData() {
		List<String> firstPage = new ArrayList<String>();

		firstPage.add("Line1");
		firstPage.add("Line2");
		firstPage.add("Line3");
		
		return new Object[][] { {firstPage}};
	}
	
	/**
	 * Data used for get last page test.
	 * 
	 * @return object with data used for get last page test
	 */
	@DataProvider
	public Object[][] validLPData() {
		List<String> lastPage = new ArrayList<String>();

		lastPage.add("Line16");
		lastPage.add("Line17");
		
		return new Object[][] { {lastPage}};
	}
	
	/**
	 * Data used for get next page test.
	 * 
	 * @return object with data used for get next page test
	 */
	@DataProvider
	public Object[][] validNPData() {
		List<String> firstPage = new ArrayList<String>();

		firstPage.add("Line10");
		firstPage.add("Line11");
		firstPage.add("Line12");
		
		return new Object[][] { {firstPage}};
	}
	
	/**
	 * Data used for get previous page test.
	 * 
	 * @return object with data used for get previous page test
	 */
	@DataProvider
	public Object[][] validPPData() {
		List<String> firstPage = new ArrayList<String>();

		firstPage.add("Line7");
		firstPage.add("Line8");
		firstPage.add("Line9");
		
		return new Object[][] { {firstPage}};
	}
	
	/**
	 * Test get pages method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validData")
	public void testGetMessages(int valid) {
		int result = pages.pagesCount();
		Assert.assertEquals(result, valid);
	}
	
	/**
	 * Test get first page method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validFPData")
	public void testFirstPage(List<String> valid) {
		List<String> result = pages.firstPage();
		Assert.assertTrue(result.equals(valid));
	}
	
	/**
	 * Test get last page method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validLPData")
	public void testLastPage(List<String> valid) {
		List<String> result = pages.lastPage();
		Assert.assertTrue(result.equals(valid));
	}
	
	/**
	 * Test get next page method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validNPData")
	public void testNext(List<String> valid) {
		
		try {
			Field field = pages.getClass().getDeclaredField("currentPage");
			field.setAccessible(true);
			field.set(pages, 2);
			List<String> result = pages.next();
			Assert.assertTrue(result.equals(valid));
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test get previous page method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validPPData")
	public void testPrevious(List<String> valid) {
		
		Field field;
		try {
			field = pages.getClass().getDeclaredField("currentPage");
			field.setAccessible(true);
			field.set(pages, 3);
			
			List<String> result = pages.previous();
			Assert.assertTrue(result.equals(valid));
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}