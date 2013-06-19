package com.sirma.itt.javacourse.gui.reverse;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Server class. Starts server using ServerSocket and wait for client to join.
 * 
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class Server {

	// class private members
	private ServerView view;
	private ServerSocket server;
	private Socket client;
	private PrintWriter writer;
	private MessageHandler msgHandler;
	private List<MessageHandler> clients;

	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view
	 *            - server GUI
	 */
	public Server(ServerView view) {
		this.view = view;
	}

	/**
	 * Find available port and starts server.
	 */
	public void startServer() {
		for (int i = 7000; i < 7020; i++) {
			try {
				server = new ServerSocket(i, 0, InetAddress.getLocalHost());
				if (server != null) {
					view.showMessage("Server is started");
					clients = Collections
							.synchronizedList(new ArrayList<MessageHandler>());
					acceptClients();
				} else {
					view.enableStartButton();
				}
				return;
			} catch (IOException e1) {
				view.showError("Can't create socket!");
			}
		}
	}

	/**
	 * Wait for clients to connect and accept them.
	 */
	public void acceptClients() {
		PrintWriter writer;
		while (true) {
			try {
				client = server.accept();
				view.showMessage("Client " + client.hashCode() + " accepted...");

				writer = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream())), true);
				writer.println("Wellcome Client " + client.hashCode());

				msgHandler = new MessageHandler(client, view);
				msgHandler.start();
				clients.add(msgHandler);
			} catch (SocketException e) {
				view.showError("Can't connect to server!");
				break;
			} catch (IOException e) {
				view.showError("Can't connect to server!");
				break;
			}
		}
	}

	/**
	 * Disconnect all clients and close server.
	 */
	public void stopServer() {
		if (clients.size() != 0) {
			disconnectClients();
		}

		if (writer != null)
			writer.close();
		try {
		} finally {
			try {
				if (client != null)
					client.close();
				if (server != null)
					server.close();
				writer = null;
				client = null;
				server = null;
				view.showMessage("Server Stopped");
			} catch (IOException e) {
				view.showError("Error in closing sockets!");
			}
		}
	}

	/**
	 * Disconnect all clients
	 */
	private void disconnectClients() {
		for (int i = 0; i < clients.size(); i++) {
			MessageHandler msgHandler = clients.remove(i);

			try {
				msgHandler.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		clients = null;
	}
}