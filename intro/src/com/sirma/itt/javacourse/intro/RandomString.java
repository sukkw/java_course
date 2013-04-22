package com.sirma.itt.javacourse.intro;

/**
 * generate random string.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class RandomString {

	/**
	 * generate random string.
	 * 
	 * @param stringLength
	 * @param minValue
	 * @param maxValue
	 */
	public String random(int stringLength, int minValue, int maxValue) {
		String randomStr = "";

		for (int i = 0; i < stringLength; i++) {
			int randomInt = 0;
			do {
				randomInt = (int) (Math.random() * (maxValue - minValue)) + minValue;
			} while ((randomInt > 57 && randomInt < 65) || (randomInt > 90 && randomInt < 97));
			char randomChar = (char) randomInt;
			randomStr += new Character(randomChar).toString();
		}

		return randomStr;
	}

}