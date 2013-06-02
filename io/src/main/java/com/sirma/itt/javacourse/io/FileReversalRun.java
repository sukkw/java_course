package com.sirma.itt.javacourse.io;

import java.io.IOException;
import java.nio.file.InvalidPathException;

/**
 * FileReversal run class
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class FileReversalRun {

	public static void main(String[] args) {

		FileReversal fileReversal = new FileReversal();
		String fileName = "testFile.txt";
		
		try {
			fileReversal.reverse(fileName);
			System.out.println(" File " + fileName + " was reversed ");
		} catch (IOException e) {
			System.out.println("Invalid path or file");
		} catch (InvalidPathException e) {
			System.out.println("Invalid path or file");
		} catch (NullPointerException e) {
			System.out.println("Invalid path or file");
		}
	}
}
