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
			fileReversal.reverse("test.txt");
		}
		catch (IOException e) {
			System.out.println("Invalid path or file");
		} catch (InvalidPathException e) {
			System.out.println("Invalid path or file");
		}

		/*
		 * public static void main(String args[]) { StringBuffer buffer = new
		 * StringBuffer("Game Plan"); buffer.reverse();
		 * System.out.println(buffer); }
		 */

		/*
		 * private String readFile( String file ) throws IOException {
		 * BufferedReader reader = new BufferedReader( new FileReader (file));
		 * String line = null; StringBuilder stringBuilder = new
		 * StringBuilder(); String ls = System.getProperty("line.separator");
		 * 
		 * while( ( line = reader.readLine() ) != null ) { stringBuilder.append(
		 * line ); stringBuilder.append( ls ); }
		 * 
		 * return stringBuilder.toString(); }
		 */
	}
}
