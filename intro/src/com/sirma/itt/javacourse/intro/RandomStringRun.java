package com.sirma.itt.javacourse.intro;

/**
 * generate random string run class.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class RandomStringRun {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RandomString randStr = new RandomString();
		System.out.println(randStr.random(20, 48, 122));
	}
}
