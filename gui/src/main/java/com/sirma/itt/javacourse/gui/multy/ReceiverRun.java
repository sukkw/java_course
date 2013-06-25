package com.sirma.itt.javacourse.gui.multy;

/**
 * Receiver run class. Creates view and starts receiver.
 *
 * @version 1.1 25 June 2013
 * @author Stella Djulgerova
 */
public class ReceiverRun {
	
	/**
	 * Class main method.
	 * @param args
	 */
	public static void main(String[] args) {
		new Receiver(new ReceiverView());
	}
}