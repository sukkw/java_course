package com.sirma.itt.javacourse.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Read text from console and write it in text file.
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class ConsoleWriter {

	// char set encoding
	private final static Charset ENCODING = StandardCharsets.UTF_8;

	/**
	 * Read lines of text from console and write it to file.
	 * 
	 */
	public void writeToFile(String fileName) {

		// create file if not exist
		if (!createFile(fileName)) {
			System.exit(0);
		}

		try {
			writeBufferedText(readText(), fileName);
		} catch (IOException e) {
			System.out.println("Can not write data! please try again.");
			return;
		}
	}
	
	/**
	 * Create file.
	 * 
	 * @param fileName - path and file name
	 */
	private boolean createFile(String fileName) {
		boolean isCreated = false;

		try {
			Path path = Paths.get(fileName);
			if (Files.exists(path)) {
				isCreated = true;
			} else {
				Files.createFile(path);
				isCreated = true;
			}
		} catch (IOException e) {
			System.out.println("Wrong path please try again.");
		} catch (InvalidPathException e) {
			System.out.println("Wrong path please try again.");
		} catch (NullPointerException e) {
			System.out.println("Wrong path please try again.");
		}
		return isCreated;
	}

	/**
	 * Read text from console.
	 * 
	 * @return - entered lines
	 */
	private String readText() {

		String textLine = "";
		StringBuilder buildText = new StringBuilder();

		System.out.println("Enter lines of text.");
		System.out.println("Enter '.' to quit.");

        while ( ! ".".equals(textLine) ) {   
        	textLine = ConsoleReader.readString();    
        	if( ".".equals(textLine) ) continue;    
        	buildText.append(textLine);
			buildText.append("\n");
        }  
		textLine = buildText.toString();
		return textLine;
	}

	/**
	 * Write text to file using buffer
	 * @param text - text to be written
	 * @param fileName - file name
	 * @throws IOException
	 */
	public void writeBufferedText(String text, String fileName)
			throws IOException {
		Path path = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
			writer.write(text);
		}
	}
}