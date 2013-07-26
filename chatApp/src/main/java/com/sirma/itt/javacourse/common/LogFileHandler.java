package com.sirma.itt.javacourse.common;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

public class LogFileHandler {

	private static Handler handler;

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
