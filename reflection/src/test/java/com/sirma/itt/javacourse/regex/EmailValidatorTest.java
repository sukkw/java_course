package com.sirma.itt.javacourse.regex;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/**
 * Test class for email validator methods.
 * 
 * @version 1.1 28 April 2013
 * @author Stella Djulgerova
 */
public class EmailValidatorTest {

	// class private members
	private String regExPattern = 
			"[A-Za-z]+([A-Za-z0-9-.])+@[A-Za-z]+([A-Za-z0-9-.])+(.[A-Za-z]{2,})";
	private EmailValidator emailValidator = new EmailValidator(regExPattern);

	/**
	 * Data used for tests.
	 * 
	 * @return object with valid e-mails
	 */
	@DataProvider
	public Object[][] ValidEmailData() {
		return new Object[][] { { new String[] { "stella@yahoo.com",
				"arrf.-100@yahoo.com", "test.100@testr.com.au",
				"allo34@r4.com", "stdd@gmail.com.com", "m--d100@gm-ail.com",
				"eee-100@yahoo-test.com" } } };
	}

	/**
	 * Data used for tests.
	 * 
	 * @return object with invalid e-mails
	 */
	@DataProvider
	public Object[][] InvalidEmailData() {
		return new Object[][] { { new String[] { "stella", "test@.com.my",
				"lili123@gmail.a", "rtt123@.com", "123@.com.com",
				".stella@mkyong.com", "eliza()*@gmail.com"} } };
	}

	/**
	 * Test validate method with valid data.
	 * 
	 * @param emails - e-mails to be tested
	 */
	@Test(dataProvider = "ValidEmailData")
	public void ValidEmailTest(String[] emails) {

		for (String email : emails) {
			boolean valid = emailValidator.validate(email);
			System.out.println("Email is valid : " + email + " , " + valid);
			Assert.assertEquals(valid, true);
		}

	}

	/**
	 * Test validate method with invalid data.
	 * 
	 * @param emails - e-mails to be tested
	 */
	@Test(dataProvider = "InvalidEmailData")
	public void InValidEmailTest(String[] emails) {

		for (String email : emails) {
			boolean valid = emailValidator.validate(email);
			System.out.println("Email is valid : " + email + " , " + valid);
			Assert.assertEquals(valid, false);
		}
	}
}