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
		try {
			fileReversal.reverse("testFile.txt");
		}
		catch (IOException e) {
			System.out.println("Invalid path or file");
		} catch (InvalidPathException e) {
			System.out.println("Invalid path or file");
		}
	}
}
