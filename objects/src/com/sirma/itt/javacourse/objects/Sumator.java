package com.sirma.itt.javacourse.objects;

import java.math.BigInteger;
import java.math.BigDecimal;

import com.sirma.itt.javacourse.intro.SumOfStrings;

/**
 * Calculate sum of numbers in different format.
 *
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class Sumator {

	/**
	 * Calculate sum of two integer numbers.
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
	 * Calculate sum of of two float numbers.
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
	 * Calculate sum of two strings.
	 *
	 * @param a
	 * @param b
	 * @return sum of the strings as number
	 */
	public String sum(String a, String b) {
		SumOfStrings sum = new SumOfStrings();
		return sum.calculate(a, b);
	}

	/**
	 * Calculate sum of two BigIntegers.
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
	 * Calculate sum of two BigDecimal.
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
