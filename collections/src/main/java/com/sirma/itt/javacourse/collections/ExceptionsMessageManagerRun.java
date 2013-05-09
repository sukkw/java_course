package com.sirma.itt.javacourse.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExceptionsMessageManagerRun {

	public static void main(String[] args) {
		
		Map<String, String> exceptions = new HashMap<String, String>();
		String repeat;
		Scanner input = new Scanner(System.in);
		
		exceptions.put("Exception1", "Invalid Debit Card Number");
		exceptions.put("Exception2", "Invalid Post Code");
		exceptions.put("Exception3", "Invalid Phone Number");
		exceptions.put("Exception4", "Invalid E-mail");
		
		ExceptionsMessageManager excManager = new ExceptionsMessageManager(exceptions);
		
		do {
			System.out.println(" 1-AddMessage / 2-AddCode / 3-GetMessage / 4-GetMessages / 5-Exit");
			repeat = input.nextLine();
			
			switch (repeat) {

				case "1":
					System.out.println("Enter Exception Message: ");
					excManager.addExceptionMessage(input.nextLine());
					break;
				case "2":
					System.out.println("Enter Exception Key: ");
					excManager.addExceptionMessageUsingCode(input.nextLine());
					break;
				case "3":
					System.out.println(excManager.getMessage());
					break;
				case "4":
					ExceptionsMessageManager.getMessages(excManager.getMessage());
					break;
				default:
					break;
			}

		} while (!"5".equals(repeat));
	}
}
