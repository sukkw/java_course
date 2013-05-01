package com.sirma.itt.javacourse.io;

import java.io.IOException;

/**
 * FileWriter run class.
 * 
 * @version 1.1 30 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleWriterRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ConsoleWriter writer = new ConsoleWriter();

		try {
			writer.writeToFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
