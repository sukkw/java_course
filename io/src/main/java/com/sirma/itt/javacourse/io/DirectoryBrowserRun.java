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
		DirectoryBrowserRecursion recBrowser = new DirectoryBrowserRecursion();
		String path = "C:\\Documents and Settings\\sdjulgerova\\git";
		
		//browser.listContent(path);
		//recBrowser.listContent(null);
		recBrowser.listContent(path);
	}
}
