package com.sirma.itt.javacourse.gui.multy;

/**
 * Transmitter run class. Creates view and starts transmitter.
 *
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class TransmitterRun {
	
	/**
	 * Class main method.
	 * @param args
	 */
	public static void main(String[] args) {
		new Transmitter(new TransmitterView(), new Mediator());
	}
}
