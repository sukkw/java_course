package com.sirma.itt.javacourse.gui.info;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * InfoThread class. Creates and starts thread each time when
 * new client is connected to server. Notify active clients that new
 * one is joined.
 * 
 * @version 1.1 18 June 2013
 * @author Stella Djulgerova
 */
public class InfoThread extends Thread {
	
	// class private members
	private List<Socket> clientsList;
	private String message;
	
	/**
	 * Constructor. Initialize variables and starts thread.
	 * @param clientsList
	 * @param message
	 */
	public InfoThread(List<Socket> clientsList, String message) {
		this.clientsList = clientsList;
		this.message = message;	
	}
	
	/**
	 * Notify all active clients when new one is join.
	 */
	public void run() {
		for (int i = 0; i < clientsList.size(); i++) {
			Socket client = (Socket) clientsList.get(i);
			try {
				PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);
				printWriter.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}