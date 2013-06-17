package com.sirma.itt.javacourse.gui.info;

import com.sirma.itt.javacourse.gui.client.Server;
import com.sirma.itt.javacourse.gui.client.ServerView;

/**
 * Server run class. Creates view and starts server.
 *
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class ServerRun {
	
	/**
	 * Class main method.
	 * @param args
	 */
	public static void main(String[] args) {
		ServerView view = new ServerView();
		new Server(view);
	}
}
