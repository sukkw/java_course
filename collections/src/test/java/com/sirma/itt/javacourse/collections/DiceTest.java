package com.sirma.itt.javacourse.collections;

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
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.io.TransferObject;

/**
 * Test class for throw dice methods.
 * 
 * @version 1.1 10 May 2013
 * @author Stella Djulgerova
 */
public class DiceTest {

	/**
	 * Data used for throw dice tests.
	 * 
	 * @return object with data used for throw dice tests
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


			//Assert.assertEquals(str.toString(), valid);
	}
}
