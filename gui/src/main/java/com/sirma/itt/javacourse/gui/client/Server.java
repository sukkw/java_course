package com.sirma.itt.javacourse.gui.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Client class. Starts client using Socket and tries to connect to server. If
 * successfully connected shows message received from server.
 * 
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class Server implements ActionListener {

	// class private members
	private ServerView view;
	private ServerSocket serverSocket;
	private Socket socket;
	private PrintWriter printWriter;

	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view - server GUI
	 */
	public Server(ServerView view) {
		this.view = view;
		view.addListener(this);
		startServer();
		sendMessage();
	}

	/**
	 * Find available port and starts server.
	 */
	private void startServer() {
		for (int i = 7000; i < 7020; i++) {
			try {
				serverSocket = new ServerSocket(i, 0,InetAddress.getLocalHost());
				return;
			} catch (IOException e1) {
				view.showError("Can't open socket!");
			}
		}
	}

	/**
	 * Detect if button stop is pressed and take action
	 */
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == view.getBtnStop()) {
			if (printWriter != null)
				printWriter.close();
			try {
				if (socket != null)
					socket.close();
				if (serverSocket != null)
					serverSocket.close();
				view.showMessage("Server stopped!");
				view.getBtnStop().setEnabled(false);
			} catch (IOException e) {
				view.showError("Error in closing sockets!");
			}
			//view.dispose();
		}
	}
 
	/**
	 *  Wait for connection with client and send message each 5 seconds.
	 */
	private synchronized void sendMessage() {

		if (serverSocket != null) {
			try {
				view.showMessage("Server started...");
				socket = serverSocket.accept();
				view.showMessage("Client join...");
				while (serverSocket != null) {
					wait(5000);
					printWriter = new PrintWriter(socket.getOutputStream(),
							true);
					Date date = new Date();
					printWriter.println("Hello " + date.toString());
					view.showMessage("Message sent...");
				}
			} catch (IOException e) {
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}