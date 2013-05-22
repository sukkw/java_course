package com.sirma.itt.javacourse.io;

import java.io.File;

/**
 * Browse directory and print content.
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class DirectoryBrowser {

	/**
	 * Print content of a directory
	 * @param path - full path of the directory or file
	 */
	public void listContent(String path) {

		// prevent from null pointer exception
		if(path == null) {
			System.out.println("Invalid file path!!");
			return;
		}
		
		File dir = new File(path);
		String[] subDirName = dir.list();
		File[] subDir = dir.listFiles();
		String separator = System.getProperty("file.separator");

		if (dir.isFile()) {
			System.out.println(" This is file " + dir.getName());
			return;

		} else if (dir.isDirectory()) {
			
			if(subDir.length == 0) {
				System.out.println("Directory is empty ");
				return;
			}

			for (int i = 0; i < subDir.length; i++) {

				if (subDir[i].isDirectory()) {
					System.out.println(separator + subDirName[i]);
				}

				System.out.println(subDirName[i]);
			}
		}
	}
}
