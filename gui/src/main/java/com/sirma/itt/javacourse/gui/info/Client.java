package com.sirma.itt.javacourse.gui.info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sirma.itt.javacourse.gui.config.Config;

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

		for (int port = Config.MIN_PORT; port < Config.MAX_PORT; port++) {
			try {
				socket = new Socket(Config.HOST, port);
				view.showMessage("Connected to server...");
				
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				view.showMessage("Server message: " + reader.readLine());
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
	public void run() {
		startClient();
		if (socket != null) {
			String message = null;
			try {
				while (true) {
					message = reader.readLine();
					if (message == null) {
						throw new NoSocketException("Server stopped!");
					} else if ("disconnected".equals(message)) {
						view.showError("The server was stopped!");
						break;
					} else {
						view.showMessage("Server message: " + message);
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
					view.dispose();
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
				view.getConnectButton().setEnabled(false);
			}
		}
	}
}