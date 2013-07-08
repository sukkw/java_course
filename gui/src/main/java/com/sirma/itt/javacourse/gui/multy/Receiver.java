package com.sirma.itt.javacourse.gui.multy;

import java.net.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import com.sirma.itt.javacourse.gui.config.Config;

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
		DatagramPacket packet = null;
	    byte[] input = new byte[Config.BUF_SIZE];

	    try {
	      //Prepare to join multicast group
	      socket = new MulticastSocket(Config.MIN_PORT);
	      InetAddress address = InetAddress.getByName(Config.CHANNEL1);
	      socket.joinGroup(address);
	      
	      InetAddress address2 = InetAddress.getByName(Config.CHANNEL2);
	      socket.joinGroup(address2);
	 
	      while (true) {
	    	  packet = new DatagramPacket(input, input.length);
	        
	        socket.receive(packet);
	        message = new String(input, 0, packet.getLength());
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
				view.getConnectButton().setEnabled(false);
			}
			
			if (event.getActionCommand() == "stop") {
				socket.close();
				view.dispose();
			}
		}
	}
}