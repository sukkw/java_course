package com.sirma.itt.javacourse.maven;

/**
 * Hangman game run class.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class HangRun {

	/**
	 * Class main method.
	 * 
	 * @param arr
	 */
	public static void main(String[] arr) {
		Hang hang = new Hang();
		hang.start("summer");
	}
}
