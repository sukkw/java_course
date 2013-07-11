package com.sirma.itt.javacourse.gui.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sirma.itt.javacourse.gui.config.Config;

/**
 * Server class. Starts server using ServerSocket and wait for client to join.
 * 
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class Server {

	// class private members
	private ServerView view;
	private ServerSocket serverSocket;
	private Socket socket;
	private PrintWriter printWriter;
	private String message;

	/**
	 * Constructor. Get reference to the view. Starts server.
	 * 
	 * @param view - server GUI
	 */
	public Server(ServerView view) {
		this.view = view;
		view.addListener(new Listener());
		startServer();
		sendMessage();
	}

	/**
	 * Find available port and starts server.
	 */
	private void startServer() {
		for (int port = Config.MIN_PORT; port < Config.MAX_PORT; port++) {
			try {
				serverSocket = new ServerSocket(port, 0,
						InetAddress.getByName(Config.HOST));
				return;
			} catch (IOException e1) {
				view.showError("Can't create socket!");
			}
		}
	}

	/**
	 * Wait for connection with client and send message each 5 seconds.
	 */
	private void sendMessage() {

		if (serverSocket != null) {
			view.showMessage("Server started.");
			while (true) {
				try {
					socket = serverSocket.accept();
					view.showMessage("New client connected.");
					printWriter = new PrintWriter(socket.getOutputStream(),
							true);
					Date date = new Date();
					message = new SimpleDateFormat("yyyy-MM-dd").format(date);
					printWriter.println("Hello " + message);
					view.showMessage("Message sent.");
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * Stop server.
	 */
	public void stopServer() {
		if (printWriter != null)
			printWriter.close();
		try {
			if (socket != null)
				socket.close();
			if (serverSocket != null)
				serverSocket.close();
			view.showMessage("Server stopped!");
			view.disableStopButton();
		} catch (IOException e) {
			view.showError("Error in closing sockets!");
		}
	}

	// Inner class. Create listener
	class Listener implements ActionListener {

		/**
		 * Detect if button stop is pressed and take action
		 */
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "stop") {
				stopServer();
				// view.dispose();
			}
		}
	}
}