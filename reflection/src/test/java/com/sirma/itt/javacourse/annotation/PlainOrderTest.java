package com.sirma.itt.javacourse.annotation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/**
 * Test class for PlainOrder methods.
 * 
 * @version 1.1 29 April 2013
 * @author Stella Djulgerova
 */
public class PlainOrderTest {

	// class private members
	private PlainOrder plainOrder = new PlainOrder();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {

		// instances to be tested
		Bomber bomber = new Bomber();
		TransportAircraft transport = new TransportAircraft();
		Airliner air = new Airliner();
		Fighter fighter = new Fighter();

		Plane[] valid = { transport, air, bomber, fighter };

		return new Object[][] { { new Plane[] { bomber, air, fighter, transport }, valid },
				{ new Plane[] { fighter, air, bomber, transport }, valid },
				{ new Plane[] { bomber, air, fighter, transport }, valid } };
	}

	/**
	 * Test orderInstance method.
	 * 
	 * @param instances - instances to be ordered
	 * @param valid - correct ordered instances
	 */
	@Test(dataProvider = "validData")
	public void orderInstances(Plane[] instances, Plane[] valid) {
		Plane[] result = plainOrder.orderInstances(instances);
		Assert.assertEquals(result, valid);
	}
}
