package com.sirma.itt.javacourse.io;

import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

/**
 * Test class for transfer object method.
 * 
 * @version 1.1 10 May 2013
 * @author Stella Djulgerova
 */
public class TransferObjectTest {

	/**
	 * Data used for transfer tests.
	 * 
	 * @return object with data used for transfer tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { {"MariqElica"}};
	}
	
	/**
	 * Test file reverse method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validData")
	public void testFileReverse(String valid) {

		String fileName = "testTransfer.txt";
		Path path = Paths.get(fileName);
		String line = null;
		StringBuilder str = new StringBuilder();

		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			
			InputStream in = new FileInputStream("testFile.txt");
			OutputStream out = new FileOutputStream("testTransfer.txt");
			TransferObject transfer = new TransferObject(in, out);
			transfer.transfer(12, 7);
			while ((line = reader.readLine()) != null) {
				str.append(line);
			}
			Assert.assertEquals(str.toString(), valid);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
