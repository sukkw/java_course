package com.sirma.itt.javacourse.io;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for serialize methods.
 * 
 * @version 1.1 10 May 2013
 * @author Stella Djulgerova
 */
public class SerializerTest {

	Serializer serializer = new Serializer();
	
	/**
	 * Data used for serialize tests.
	 * 
	 * @return object with data used for serialize tests
	 */
	@DataProvider
	public Object[][] validData() {
		DataClass object = new DataClass("XX-Lg-675P", 156.90, 3452);
		object.setQty(12);
		object.setAvailable(true);
		return new Object[][] { {object}};
	}
	
	/**
	 * Test deserialize method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validData")
	public void testGetObject(DataClass valid) {
		serializer.saveObject("serialize.ser", valid);
		DataClass object = (DataClass) serializer.getObject("serialize.ser");
		Assert.assertEquals(object.getName(), valid.getName());
		Assert.assertEquals(object.getNumber(), valid.getNumber());
		Assert.assertEquals(object.getQty(), valid.getQty());
		Assert.assertEquals(object.getValue(), valid.getValue());
		Assert.assertEquals(object.isAvailable(), valid.isAvailable());
	}
}
