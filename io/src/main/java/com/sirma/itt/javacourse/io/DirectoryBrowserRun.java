package com.sirma.itt.javacourse.io;

/**
 * DirectoryBrowser run class.
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class DirectoryBrowserRun {

	/**
	 * Class main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		DirectoryBrowser browser = new DirectoryBrowser();
		browser.listContent("C:\\Users\\Eli\\git\\io");
	}
}
