package com.sirma.itt.javacourse.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.sirma.itt.javacourse.io.ConsoleReader;

/**
 * ExceptionsMessageManager run class. 
 * Allows user to chose action and print results on screen.
 * 
 * @version 1.1 09 May 2013
 * @author Stella Djulgerova
 */
public class ExceptionsMessageManagerRun {

	/**
	 * Class main method
	 * @param args
	 */
	public static void main(String[] args) {

		Map<String, String> exceptions = new HashMap<String, String>();
		String repeat;

		// map is filled with different exceptions
		exceptions.put("Exception1", "Invalid Debit Card Number");
		exceptions.put("Exception2", "Invalid Post Code");
		exceptions.put("Exception3", "Invalid Phone Number");
		exceptions.put("Exception4", "Invalid E-mail");

		ExceptionsMessageManager excManager = new ExceptionsMessageManager(
				exceptions);

		// repeat while user chose to stop
		do {
			System.out
					.println(" 1-AddMessage / 2-AddCode / 3-GetMessage / 4-GetMessages / 5-Exit");
			repeat = ConsoleReader.readString();

			switch (repeat) {

			case "1":
				System.out.println("Enter Exception Message: ");
				try {
					excManager.addExceptionMessage(ConsoleReader.readString());
				} catch (InvalidValueException e) {
                    System.err.println(e.getMessage());
                }
				break;
			case "2":
				System.out.println("Enter Exception Key: ");
				try {
					excManager.addExceptionMessageCode(ConsoleReader.readString());
				} catch (InvalidValueException e) {
					System.err.println(e.getMessage());
				}
				break;
			case "3":
				System.out.println(excManager.getMessage());
				break;
			case "4":
				try {
				System.out.println(ExceptionsMessageManager
						.getMessages((excManager.getMessage())));
				} catch (NullPointerException e) {
					System.err.println("Invalid message combination!");
				}
				break;
			default:
				break;
			}

		} while (!"5".equals(repeat));
	}
}