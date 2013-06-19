package com.sirma.itt.javacourse.gui.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Server class. 
 * Starts server using ServerSocket and wait for client to join.
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
	 * Constructor. Get reference to the view. Starts server.
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
				view.showError("Can't create socket!");
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
	private void sendMessage() {

		if (serverSocket != null) {
			try {
				view.showMessage("Server started...");
				socket = serverSocket.accept();
				view.showMessage("Client join...");
				while (serverSocket != null) {
					Thread.sleep(5000);
					printWriter = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())),true);
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