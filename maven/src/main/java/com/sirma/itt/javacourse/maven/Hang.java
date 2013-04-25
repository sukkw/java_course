package com.sirma.itt.javacourse.maven;

import java.io.*;

/**
 * Hangman game.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class Hang {

	/**
	 * Start the game.
	 * 
	 * @param word - the hidden word which player must find
	 */
	public void start(String word) {

		//generate temporary word visible to player
		String tempWord = "";
		for (int i = 0; i < word.length(); i++) {
			tempWord += "-";
		}

		// Max allowed tries are 5
		final int ERROR_COUNTER = 5;

		char enterdChar;

		int count = 0;
		int rightCount = 0;

		System.out.println(tempWord + " Vuvedete bukva");

		do {
			enterdChar = readChar();
			boolean match = false;

			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == enterdChar) {
					match = true;
					tempWord = replaceCharAt(tempWord, i, enterdChar);
				}
			}
			if (match) {
				System.out.println(tempWord);
				rightCount++;
			} else {
				System.out.println(tempWord);
				count++;
			}

		} while (rightCount < word.length() && count < ERROR_COUNTER);

		if (word.equalsIgnoreCase(tempWord)) {
			System.out.println("Dumata e vqrna.");
		} else {
			System.out.println("Opitajte otnovo.");
		}
	}

	/**
	 * Read character from console.
	 * 
	 * @return character entered by user
	 */
	private char readChar() {
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;

		try {
			line = br.readLine();
		} catch (Exception e) {

		}
		return line.toLowerCase().charAt(0);
	}

	/**
	 * Replace a char in the temporary word with correct letter.
	 * 
	 * @param str - temporary word
	 * @param pos - position where the match occurred.
	 * @param ch - entered char
	 * @return
	 */
	public String replaceCharAt(String str, int pos, char ch) {
		return str.substring(0, pos) + ch + str.substring(pos + 1);
	}

}
