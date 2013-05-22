package com.sirma.itt.javacourse.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Read from text file. Reverse the content and write it to the file
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class FileReversal {

	// class private members
	private final static Charset ENCODING = StandardCharsets.US_ASCII;

	/**
	 * Reverse content of text file
	 * @param fileName - file to be reversed
	 * @throws IOException
	 */
	public void reverse(String fileName) throws IOException {

		Path path = Paths.get(fileName);
		StringBuffer buffer = new StringBuffer();
		List<String> lines = new ArrayList<String>();
		ConsoleWriter writer = new ConsoleWriter();
		String line = null;
		
		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {
			
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
			}
			buffer = buffer.reverse();
			lines.add(buffer.substring(1, buffer.length()));
			writer.writeBufferedText(lines, fileName);
		}
		
		System.out.println(" File " + fileName + " was reversed ");
	}
}
