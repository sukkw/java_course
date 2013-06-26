package com.sirma.itt.javacourse.gui.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client class. Starts client using Socket and tries to connect to server. If
 * successfully connected shows message received from server.
 * 
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class Client {

	// class private members
	private ClientView view;
	private Socket socket;
	private BufferedReader reader;
	private String message;

	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view
	 *            - client GUI
	 */
	public Client(ClientView view) {
		this.view = view;
		startClient();
		readMessage();
	}

	/**
	 * Find available port and starts client.
	 */
	private void startClient() {
		for (int i = 7000; i < 7020; i++) {
			try {
				socket = new Socket(InetAddress.getLocalHost(), i);
				return;
			} catch (UnknownHostException e1) {
				view.showError("Can't find server!");
			} catch (IOException e1) {
				view.showError("Can't create socket!");
			}
		}
	}

	/**
	 * Receive message from server and print it on screen.
	 */
	public void readMessage() {
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			message = reader.readLine();

			if (socket != null && message != null) {
				view.showMessage("Connected...");
				view.showMessage("Message received...");
				view.showMessage(message);
			} else {
				view.showMessage("No server found...");
			}

			view.showMessage("Disconnected...");
			reader.close();
			socket.close();
		} catch (IOException e) {
			view.showError("Can't read from socket!");
		}
	}
}