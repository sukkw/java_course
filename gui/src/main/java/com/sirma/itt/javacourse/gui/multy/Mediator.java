package com.sirma.itt.javacourse.gui.multy;

/**
 * Mediator class. Determine which channel to be used
 * for transmit message.
 * 
 * @version 1.1 25 June 2013
 * @author Stella Djulgerova
 */
public class Mediator {
	
	/**
	 * Generate random number and choose channel.
	 * @return - selected channel
	 */
	public String getChannel() {
		String channel;
		
		int channelNumber = (int) (Math.random() * 2);

		if(channelNumber == 0) {
			channel = "235.0.0.1";
		} else {
			channel = "235.255.0.1";
		}
		return channel;
	}
}
