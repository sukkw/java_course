package com.sirma.itt.javacourse.io;

/**
 * FileWriter run class.
 * 
 * @version 1.1 01 May 2013
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
		
		System.out.println("Enter path to the file : ");
		String fileName = ConsoleReader.readString()+ ".txt";
		writer.writeToFile(fileName);
	}
}
