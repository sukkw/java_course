package com.sirma.itt.javacourse.gui.info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

import com.sirma.itt.javacourse.gui.config.Config;

/**
 * Server class. Starts server using ServerSocket and wait for client to join.
 * 
 * @version 1.1 18 June 2013
 * @author Stella Djulgerova
 */
public class Server {

	// class private members
	private ServerView view;
	private ServerSocket serverSocket;
	private Socket connectedClient;
	private PrintWriter printWriter;
	private Vector<Socket> clients;
	private String message;

	/**
	 * Constructor. Get reference to the view. Starts server.
	 * 
	 * @param view
	 *            - server GUI
	 */
	public Server(ServerView view) {
		this.view = view;
		view.setListeners(new Listener());
		startServer();
		acceptClients();
	}

	/**
	 * Find available port and starts server.
	 */
	public void startServer() {
		for (int port = Config.MIN_PORT; port < Config.MAX_PORT; port++) {
			try {
				serverSocket = new ServerSocket(port, 0,
						InetAddress.getByName(Config.HOST));
				view.showMessage("Server Strted at port " + port);
				return;
			} catch (IOException e1) {
				view.showError("Can't open socket!");
			}
		}
	}

	/**
	 * Wait for clients to connect and send message.
	 */
	private void acceptClients() {
		clients = new Vector<Socket>();

		int clientsNumber = 1;

		while (true) {
			try {
				connectedClient = serverSocket.accept();
				view.showMessage("Client " + clientsNumber + " accepted...");

				printWriter = new PrintWriter(
						connectedClient.getOutputStream(), true);
				printWriter.println("You are Client " + clientsNumber);
			} catch (SocketException e) {
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

			message = "Client " + clientsNumber + " is connected...";
			InfoThread infoThread = new InfoThread(clients, message);
			infoThread.start();
			clients.add(connectedClient);

			clientsNumber++;
		}
	}

	/**
	 * Stop server and notifies the connected clients.
	 */
	public void stopServer() {
		view.showMessage("Server Stopped...");
		message = "disconnected";
		new InfoThread(clients, message);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (printWriter != null)
			printWriter.close();
		try {
		} finally {
			try {
				if (connectedClient != null)
					connectedClient.close();
				if (serverSocket != null)
					serverSocket.close();
			} catch (IOException e) {
				view.showError("Error closing sockets!");
			}
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
				view.getStopButton().setEnabled(false);
			}
		}
	}
}