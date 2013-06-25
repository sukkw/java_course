package com.sirma.itt.javacourse.patterns;

import java.lang.reflect.Field;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.fluent.Mail;

/**
 * Test class for fluent interface design pattern.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class MailTest {
	
	private Mail mail = new Mail("sdjulgerova@gmail.com");
	
	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { mail }};
	}

	/**
	 * Test addReciver method.
	 * 
	 * @param valid - correct instance
	 */
	@Test(dataProvider = "validData")
	public void addReciver(Mail valid) {
		Mail reciver = mail.addReciver("sdjulgerova@abv.bg");
		Assert.assertEquals(reciver, valid);
		
		try {
			Field f = mail.getClass().getDeclaredField("to");
			f.setAccessible(true);
			String to = (String) f.get(mail);
			f.setAccessible(false);
			Assert.assertEquals(to, "sdjulgerova@abv.bg");
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
	 * Test addSubject method.
	 * 
	 * @param valid - correct instance
	 */
	@Test(dataProvider = "validData")
	public void addSubject(Mail valid) {
		Mail reciver = mail.addSubject("Test");
		Assert.assertEquals(reciver, valid);
		
		try {
			Field f = mail.getClass().getDeclaredField("subject");
			f.setAccessible(true);
			String subject = (String) f.get(mail);
			f.setAccessible(false);
			Assert.assertEquals(subject, "Test");
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
	 * Test addContent method.
	 * 
	 * @param valid - correct instance
	 */
	@Test(dataProvider = "validData")
	public void addContent(Mail valid) {
		Mail reciver = mail.addContent("Text");
		Assert.assertEquals(reciver, valid);
		
		try {
			Field f = mail.getClass().getDeclaredField("content");
			f.setAccessible(true);
			String content = (String) f.get(mail);
			f.setAccessible(false);
			Assert.assertEquals(content, "Text");
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
	 * Test addReciver method.
	 * 
	 * @param valid - correct instance
	 */
	@Test(dataProvider = "validData")
	public void addCC(Mail valid) {
		Mail reciver = mail.addCC("eli-mar22@abv.bg");
		Assert.assertEquals(reciver, valid);
		
		try {
			Field f = mail.getClass().getDeclaredField("CC");
			f.setAccessible(true);
			String CC = (String) f.get(mail);
			f.setAccessible(false);
			Assert.assertEquals(CC, "eli-mar22@abv.bg");
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