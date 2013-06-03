package com.sirma.itt.javacourse.io;

import java.io.File;

/**
 * Browse directory and print content.
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class DirectoryBrowserRecursion {
	
	/**
	 * Print content of a directory using recursion
	 * 
	 * @param path - full path of the directory or file
	 */
	public void listContent(String path) {

		// prevent from null pointer exception
		if(path == null) {
			System.out.println("Invalid file path!!");
			return;
		}
		
		File dir = new File(path);
		String[] chld = dir.list();
		if (dir.isFile()) {
			System.out.println("  " + dir.getName());
			return;

		} else if (dir.isDirectory()) {
			System.out.println(path.substring(path.lastIndexOf(File.separator)));
			for (int i = 0; i < chld.length; i++) {
				listContent(path + File.separator + chld[i]);
			}
		}
	}
}