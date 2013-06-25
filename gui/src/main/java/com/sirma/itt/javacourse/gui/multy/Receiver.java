package com.sirma.itt.javacourse.gui.multy;

import java.net.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Receiver class. Starts receiver who listen from server messages at
 * specified channel.
 * 
 * @version 1.1 25 June 2013
 * @author Stella Djulgerova
 */
public class Receiver extends Thread {

	// class private members
	private ReceiverView view;
	private MulticastSocket socket = null;
	private String message;
	
	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view - client GUI
	 */
	public Receiver(ReceiverView view) {
		this.view = view;
		view.addListeners(new Listener());
	}
	
	/**
	 * Creates socket and join multicast group 
	 */
	public void run() {
		DatagramPacket inPacket = null;
	    byte[] inBuf = new byte[256];
	    String channel1 = "235.0.0.1";
	    String channel2 = "235.255.0.1";
	    int port = 7000;

	    try {
	      //Prepare to join multicast group
	      socket = new MulticastSocket(port);
	      InetAddress address = InetAddress.getByName(channel1);
	      socket.joinGroup(address);
	      
	      InetAddress address2 = InetAddress.getByName(channel2);
	      socket.joinGroup(address2);
	 
	      while (true) {
	        inPacket = new DatagramPacket(inBuf, inBuf.length);
	        
	        socket.receive(inPacket);
	        message = new String(inBuf, 0, inPacket.getLength());
	        view.showMessage("Receive message : " + message);
	      }
	    } catch (IOException ioe) {
	    }
	}
	
	// Inner class. Create listener
	class Listener implements ActionListener {
		
		/**
		 * Detect if button is pressed and take action
		 */
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "connect") {
				start();
				view.disableConnectButton();
			}
			
			if (event.getActionCommand() == "stop") {
				socket.close();
				view.dispose();
			}
		}
	}
}