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
	      String msg;
	 
	      while (true) {
	    	channel = mediator.getChannel();
	        msg = "This is multicast message # " + counter + " at channel " + channel;
	        counter++;
	        outBuf = msg.getBytes();
	 
	        //Send to multicast IP address and port
	        InetAddress address = InetAddress.getByName(channel);
	        outPacket = new DatagramPacket(outBuf, outBuf.length, address, port);
	 
	        socket.send(outPacket);
	 
	        view.showMessage("Server sends : " + msg);
	        try {
	          Thread.sleep(1000);
	        } catch (InterruptedException ie) {
	        }
	      }
	    } catch (IOException ioe) {
	 
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