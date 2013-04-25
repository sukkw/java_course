package com.sirma.itt.javacourse.maven;

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
		StringBuilder randomStr = new StringBuilder();

		for (int i = 0; i < stringLength; i++) {
			int randomInt = 0;
			
			//repeat while we get allowed symbol
			do {
				randomInt = (int) ((Math.random() * (maxValue - minValue)) + minValue);
			} while ((randomInt > 57 && randomInt < 65) || (randomInt > 90 && randomInt < 97));
			
			// convert to char and add to string
			char randomChar = (char) randomInt;
			randomStr.append(randomChar);
		}

		return randomStr.toString();
	}

}