package com.sirma.itt.javacourse.gui.reverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import com.sirma.itt.javacourse.gui.config.Config;
import com.sirma.itt.javacourse.gui.info.NoSocketException;

/**
 * Client class. Starts client using Socket and tries to connect to server. 
 * If successfully connected shows message received from server.
 * Sends messages to server.
 * 
 * @version 1.1 19 June 2013
 * @author Stella Djulgerova
 */
public class Client extends Thread {

	// class private members
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private ClientView view;
	private String message;

	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view - client GUI
	 */
	public Client(ClientView view) {
		this.view = view;
	}

	/**
	 * Find available port and create socket.
	 */
	public boolean connect() {
		for (int port = Config.MIN_PORT; port < Config.MAX_PORT; port++) {
			try {
				socket = new Socket(Config.HOST, port);

				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				writer = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
				String message = reader.readLine();
				if(message == null) {
					view.showMessage("No server ");
					return false;
				}
				view.showMessage("Server message >>> " + message);

				view.resetMsgField(true);
				return true;

			} catch (IOException e1) {
				view.showError("Can't create socket!");
				view.enableConnectButton();
			}
		}
		return false;
	}

	/**
	 * Read messages.
	 */
	public synchronized void run() {
		if (connect()) {
			String reversedMessage = null; 
											
			try {
				while (true) {
					
					if ((message == null) || ("".equals(message))) { 				
						try {
							wait(); 
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (".".equals(message)) { 
						view.showError("You are disconnected...");
						writer.println(message); 
						break;
					} else {
						writer.println(message); 
						reversedMessage = reader.readLine(); 

						if (("disconnected".equals(reversedMessage))
								|| (reversedMessage == null)) {
							view.showError("Server is disconnected!");
							throw new NoSocketException("Can't find server!");
						}
						view.showMessage("The reverse of [ " + message + " ] is [ "
								+ reversedMessage + " ]");
					}
					message = null;
				}
			} catch (IOException e) {
				view.showError("Disconnected!");
			} finally {
				view.resetMsgField(false);
				try {
					if (reader != null)
						reader.close();
					if (socket != null)
						socket.close();
					view.setVisible(false);
					view.dispose();
					view = null;
				} catch (IOException e) {
					view.showError("Error closing stream/socket!");
				}
			}
		}
	}
	
	/**
	 * Get message entered by user.
	 * @param message - message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/** 
	 * Notify thread.
	 */
	public synchronized void wakeUp() {
		notify();
	}
	
	/**
	 * Creates memento object that keep message entered by user.
	 * 
	 * @param message - message
	 * @return - memento object
	 */
	public Memento store(String message) { 
	    return new Memento(message); 
	}

	/**
	 * Get string from memento object.
	 * @param memento
	 * @return
	 */
	public String restore(Memento memento) {
		return memento.getSavedMessage();  
	}
}