package com.sirma.itt.javacourse.gui.client;

/**
 * Client run class. Creates view and starts client.
 *
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class ClientRun {
	
	/**
	 * Class main method.
	 * @param args
	 */
	public static void main(String[] args) {
		ClientView view = new ClientView();
		new Client(view);
	}
}