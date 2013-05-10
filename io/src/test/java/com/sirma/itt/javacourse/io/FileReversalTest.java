package com.sirma.itt.javacourse.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for file reverse method.
 * 
 * @version 1.1 10 May 2013
 * @author Stella Djulgerova
 */
public class FileReversalTest {

	FileReversal revers = new FileReversal();

	/**
	 * Data used for reverse tests.
	 * 
	 * @return object with data used for reverse tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { {"54321"}};
	}
	
	/**
	 * Test file reverse method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validData")
	public void testFileReverse(String valid) {

		String fileName = "test.txt";
		Path path = Paths.get(fileName);
		String line = null;
		StringBuilder str = new StringBuilder();

		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			revers.reverse(fileName);
			while ((line = reader.readLine()) != null) {
				str.append(line);
			}
			Assert.assertEquals(str.toString(), valid);
			revers.reverse(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
