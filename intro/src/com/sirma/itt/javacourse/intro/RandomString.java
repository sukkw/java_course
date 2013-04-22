package com.sirma.itt.javacourse.intro;

/**
 * Generate random string.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class RandomString {

	/**
	 * Generate random string.
	 * 
	 * @param stringLength - length of the string to be generated
	 * @param minValue - minimal value of allowed chars in string (ASCII)
	 * @param maxValue - maximal value of allowed chars in string (ASCII)
	 */
	public String random(int stringLength, int minValue, int maxValue) {
		String randomStr = "";

		for (int i = 0; i < stringLength; i++) {
			int randomInt = 0;
			do {
				randomInt = (int) (Math.random() * (maxValue - minValue)) + minValue;
			} while ((randomInt > 57 && randomInt < 65) || (randomInt > 90 && randomInt < 97));
			char randomChar = (char) randomInt;
			randomStr += randomChar;
		}

		return randomStr;
	}

}