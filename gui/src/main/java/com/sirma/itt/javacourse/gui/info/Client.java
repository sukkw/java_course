package com.sirma.itt.javacourse.gui.info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client class. Starts client using Socket and tries to connect to server. 
 * If successfully connected shows message received from server.
 * 
 * @version 1.1 18 June 2013
 * @author Stella Djulgerova
 */
public class Client extends Thread {

	// class private members
	private Socket socket = null;
	private BufferedReader reader;
	private ClientView view;
	
	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view - client GUI
	 */
	public Client(ClientView view) {
		this.view = view;
		view.addListeners(new Listener());
	}

	/**
	 * Find available port and starts client.
	 */
	public void startClient() {

		for (int i = 7000; i < 7020; i++) {
			try {
				socket = new Socket(InetAddress.getLocalHost(), i);
				view.showMessage("Connected to server...");
				// create input stream to read from server
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				view.showMessage("Server message " + reader.readLine());
				return;
			} catch (UnknownHostException e1) {
				view.showError("Can't find server!");
			} catch (IOException e1) {
				view.showError("Can't create socket!");
			}
		}
	}

	/**
	 * Receive messages from server and print it on screen.
	 * If server is closed throws NoSocketException and close client.
	 */
	public void run() throws NoSocketException {
		startClient();
		if (socket != null) {
			String s = null;
			try {
				while (true) {
					s = reader.readLine();
					if (s == null) {
						throw new NoSocketException("Server stopped!");
					} else if ("disconnected".equals(s)) {
						view.showError("The server was stopped!");
						break;
					} else {
						view.showMessage("Server message " + s);
					}
				}
			} catch (IOException e) {
				view.showError("Error during reading!");
			} finally {
				try {
					if (reader != null)
						reader.close();
					if (socket != null)
						socket.close();
					view.setVisible(false);
					view.dispose();
					view = null;
				} catch (IOException e) {
					view.showError("Error in closing!");
				}
			}
		}
	}

	// Inner class. Create listener
	class Listener implements ActionListener {
		
		/**
		 * Detect if button connect is pressed and take action
		 */
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "connect") {
				start();
				view.disableConnectButton();
			}
		}
	}
}