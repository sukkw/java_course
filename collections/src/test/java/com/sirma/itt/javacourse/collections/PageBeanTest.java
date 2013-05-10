package com.sirma.itt.javacourse.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
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
	public Object[][] validMessagesData() {
		return new Object[][] { {5}};
	}
	
	/**
	 * Test get pages method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validMessagesData")
	public void testGetMessages(int valid) {
		int result = pages.pagesCount();
		Assert.assertEquals(result, valid);
	}
}
