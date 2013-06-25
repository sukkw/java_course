package com.sirma.itt.javacourse.gui.multy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

/**
 * Transmitter class. Starts transmitter who sends message
 * each second.
 * 
 * @version 1.1 25 June 2013
 * @author Stella Djulgerova
 */
public class Transmitter {

	// class private members
	private TransmitterView view;
	private Mediator mediator;
	private DatagramSocket socket = null;
	private String message;
	
	/**
	 * Constructor. Initialize variables and starts to transmit.
	 * 
	 * @param view - transmitter GUI
	 * @param mediator - transmitter mediator
	 */
	public Transmitter(TransmitterView view , Mediator mediator) {
		this.view = view;
		this.mediator = mediator;
		view.setListeners(new Listener());
		startTransmiter();
	}
	
	/**
	 * Starts transmitter. Generate and send message each second to
	 * the specified channel.
	 */
	public void startTransmiter() {

	    DatagramPacket outPacket = null;
	    byte[] outBuf;
	    int port = 7000;
	    String channel;
	 
	    try {
	      socket = new DatagramSocket();
	      long counter = 0;
	 
	      while (true) {
	    	channel = mediator.getChannel();
	    	message = "This is multicast message # " + counter + " at channel " + channel;
	        counter++;
	        outBuf = message.getBytes();
	 
	        //Send to multicast IP address and port
	        InetAddress address = InetAddress.getByName(channel);
	        outPacket = new DatagramPacket(outBuf, outBuf.length, address, port);
	 
	        socket.send(outPacket);
	 
	        view.showMessage("Server sends : " + message);
	        Thread.sleep(1000);
	      }
	    } catch (IOException ioe) {
	    } catch (InterruptedException ie) {
        }
	    
	}
	
	// Inner class. Create listener
	class Listener implements ActionListener {
		
		/**
		 * Detect if button stop is pressed and take action
		 */
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "stop") {
				socket.close();
				view.dispose();
			}
		}
	}
}