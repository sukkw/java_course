package com.sirma.itt.javacourse.intro;

/**
 * Sum two numbers when present the digits as string
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class SumOfStrings {

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
				firstString = firstString.substring(0, firstString.length() - 1);
			} else {
				ldcFirstString = '0';
			}

			if (secondString.length() > 0) {
				// save the last char and take the remaining substring
				ldcSecoundString = secondString.charAt(secondString.length() - 1);
				secondString = secondString.substring(0, secondString.length() - 1);
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
