package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;

/**
 * Calculate sum of two numbers when present the digits as string
 * 
 * @version 1.1 20 April 2013
 * @author Stella Djulgerova
 */
public class Sumator {

	/**
	 * Chech entered string for valid data
	 * @param str
	 * @return
	 */
	public String validate(String str) {
		boolean checker = true;
		do {
			try {
				for (int i = 0; i < str.length(); i++) {
					Integer.parseInt(str.charAt(i) + "");
				}
				checker = false;
			} catch (NumberFormatException e) {
				System.out.println("Chisloto koeto ste vuveli ne e sustaveno ot cifri!");
				Scanner input = new Scanner(System.in);
				str = read();
			}
		} while (checker);
		return str;
	}

	/**
	 * Read string from console
	 * @return
	 */
	public String read() {

		String str;

		Scanner input = new Scanner(System.in);

		System.out.print("Vuvedete chislo : ");
		str = input.next();
		
		return validate(str);
	}
	

	/**
	 * Calculate value of two strings as number
	 * 
	 * @param firstString
	 * @param secondString
	 * @return sum of firstString and secondString
	 */
	public String calculate(String firstString, String secondString) {

		char ldcFirstString, ldcSecoundString;
		int ldiFirstString, ldiSecoundString;
		int transfer = 0;
		int tempSum;
		String sumAsString = "";

		while (firstString.length() > 0 || secondString.length() > 0) {

			if (firstString.length() > 0) {
				// save the last char and take the remaining substring
				ldcFirstString = firstString.charAt(firstString.length() - 1);
				firstString = firstString
						.substring(0, firstString.length() - 1);
			} else {
				ldcFirstString = '0';
			}

			if (secondString.length() > 0) {
				// save the last char and take the remaining substring
				ldcSecoundString = secondString
						.charAt(secondString.length() - 1);
				secondString = secondString.substring(0,
						secondString.length() - 1);
			} else {
				ldcSecoundString = '0';
			}

			// convert the char values to integer
			ldiFirstString = Integer.parseInt(ldcFirstString + "");
			ldiSecoundString = Integer.parseInt(ldcSecoundString + "");

			// calculate the sum as integer value and add transfer
			tempSum = ldiFirstString + ldiSecoundString + transfer;

			if (tempSum > 9) {
				transfer = tempSum;
				// get last digit (if sum is 12 - 2)
				tempSum -= 10;
			}

			// get the reminder (if sum is 12 - 1)
			transfer /= 10;

			// add new digit to string
			sumAsString = tempSum + sumAsString;
		}

		// if transfer is bigger than 0 after last iteration add it to string
		if (transfer > 0) {
			sumAsString = (new Integer(transfer)).toString() + sumAsString;
		}

		return sumAsString;
	}
}
