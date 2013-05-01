package com.sirma.itt.javacourse.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Read text from console and write it in text file.
 * 
 * @version 1.1 30 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleWriter {

	/**
	 * Read lines of text from console and write it to file
	 * 
	 * @throws IOException
	 */
	public void read() throws IOException {

		// Create a BufferedReader using System.in
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(
				System.in));

		String textLine;
		String input = "";
		PrintWriter printWriter = null;

		System.out.println("Enter path and file name: ");
		String fileName = buffReader.readLine() + ".txt";
		
		try {
			printWriter = new PrintWriter(new FileWriter(fileName), true);

		} catch (FileNotFoundException e) {
			System.out.println("  Wrong file name. Please try again! ");
			return;
		}

		System.out.println("Enter lines of text.");
		System.out.println("Enter '.' to quit.");

		do {
			textLine = buffReader.readLine();
			input += textLine + "\n";
		} while (!textLine.equals("."));

		input = input.substring(0, input.length() - 2);

		printWriter.write(input);
		printWriter.close();
	}
}
