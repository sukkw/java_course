package com.sirma.itt.javacourse.servermain;

import com.sirma.itt.javacourse.server.ServerMainThread;

/**
 * Server run class. Starts server.
 * 
 * @version 1.1 03	July 2013
 * @author Stella Djulgerova
 */
public class ServerStartClass {
	
	/**
	 * Class main method
	 * @param args
	 */
	public static void main(String[] args) {
		new ServerMainThread();
	}
}

