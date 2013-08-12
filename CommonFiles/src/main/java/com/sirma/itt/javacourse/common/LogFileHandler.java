package com.sirma.itt.javacourse.common;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

/**
 * This class creates file handler which is used for logger.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class LogFileHandler {

	private static Handler handler;

	/**
	 * Creates file handler. All log info will be written in this file.
	 * 
	 * @return file handler
	 */
	public static Handler getHandler() {
		try {
			handler = new FileHandler("logfile.txt");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return handler;
	}
}
