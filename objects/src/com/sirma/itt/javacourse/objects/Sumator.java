package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Calculate sum of numbers in different format
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class Sumator {

	/**
	 * Calculate sum of two integer numbers
	 * 
	 * @param a
	 * @param b
	 * @return sum of the numbers
	 */
	public int sum(int a, int b) {
		int sum = a + b;
		return sum;
	}

	/**
	 * Calculate sum of of two float numbers
	 * 
	 * @param a
	 * @param b
	 * @return sum of the numbers
	 */
	public float sum(float a, float b) {
		float sum = a + b;
		return sum;
	}

	/**
	 * Calculate sum of two strings
	 * 
	 * @param a
	 * @param b
	 * @return sum of the strings as number
	 */
	public String sum(String a, String b) {
		char ldcFirstString, ldcSecoundString;
		int ldiFirstString, ldiSecoundString;
		int transfer = 0;
		int tempSum;
		String sumAsString = "";

		while (a.length() > 0 || b.length() > 0) {

			if (a.length() > 0) {
				// save the last char and take the remaining substring
				ldcFirstString = a.charAt(a.length() - 1);
				a = a.substring(0, a.length() - 1);
			} else {
				ldcFirstString = '0';
			}

			if (b.length() > 0) {
				// save the last char and take the remaining substring
				ldcSecoundString = b.charAt(b.length() - 1);
				b = b.substring(0, b.length() - 1);
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

	/**
	 * Calculate sum of two BigIntegers
	 * 
	 * @param a
	 * @param b
	 * @return sum of the numbers
	 */
	public BigInteger sum(BigInteger a, BigInteger b) {
		BigInteger sum = a.add(b);
		return sum;
	}

	/**
	 * Calculate sum of two BigDecimal
	 * 
	 * @param a
	 * @param b
	 * @return sum of the numbers
	 */
	public BigDecimal sum(BigDecimal a, BigDecimal b) {
		BigDecimal sum = a.add(b);
		return sum.setScale(3, BigDecimal.ROUND_UP);
	}

}
