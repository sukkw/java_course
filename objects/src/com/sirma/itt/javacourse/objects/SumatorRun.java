package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Sumator run class
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class SumatorRun {
	/**
	 * Class main method
	 * 
	 * @param arr
	 */
	public static void main(String[] args) {

		Sumator sumator = new Sumator();
		System.out.println("int " + sumator.sum(5, 7));
		System.out.println("float " + sumator.sum(3.5f, 7.8454f));
		System.out.println("string " + sumator.sum("768654", "32552"));

		BigInteger aBigInt = new BigInteger("454252354");
		BigInteger bBigInt = new BigInteger("78356774");
		System.out.println("BigInt " + sumator.sum(aBigInt, bBigInt));

		BigDecimal aBigDec = new BigDecimal(234.232323);
		BigDecimal bBigDec = new BigDecimal(35673.9467334);
		System.out.println("BigDec " + sumator.sum(aBigDec, bBigDec));
		
	}
}
