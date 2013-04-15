package com.sirma.itt.javacourse.intro;

import java.io.*;

/**
 * hangman game
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class Hang {

	/**
	 * Start the game
	 */
	public void start(String word) {

		String tempWord = "";
		for(int i=0; i<word.length(); i++) {
			tempWord += "-";
		}
		
		// Max allowed tries are 5
		final int ERROR_COUNTER = 5;

		char enterdChar;

		int count = 0;
		int rightcount = 0;

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
				rightcount++;
				count++;
			} else {
				System.out.println("Opitajte otnovo");
				System.out.println(tempWord);
				count++;
			}

		} while (rightcount < word.length() && count < ERROR_COUNTER);

		if (word.equalsIgnoreCase(tempWord)) {
			System.out.println("Dumata e vqrna.");
		} else {
			System.out.println("Opitajte otnovo.");
		}
	}

	/**
	 * read character from console
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
	 * Replace a char in the temporary word with correct letter
	 * 
	 * @param s
	 * @param pos
	 * @param c
	 * @return
	 */
	public String replaceCharAt(String str, int pos, char ch) {
		return str.substring(0, pos) + ch + str.substring(pos + 1);
	}

}
