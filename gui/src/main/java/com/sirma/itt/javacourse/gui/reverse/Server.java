package com.sirma.itt.javacourse.gui.reverse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

import com.sirma.itt.javacourse.gui.config.Config;

/**
 * Starts server using ServerSocket and wait for client to join.
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
	private Vector<MessageHandler> clients;

	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view - server GUI
	 */
	public Server(ServerView view) {
		this.view = view;
	}

	/**
	 * Find available port and starts server.
	 */
	public void startServer() {
		for (int port = Config.MIN_PORT; port < Config.MAX_PORT; port++) {
			try {
				server = new ServerSocket(port, 0, InetAddress.getByName(Config.HOST));
				if (server != null) {
					view.showMessage("Server is started");
					clients = new Vector<MessageHandler>();
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
				view.showMessage("Client " + client.getInetAddress() + " accepted...");

				writer = new PrintWriter(client.getOutputStream(), true);
				writer.println("Wellcome Client " + client.getInetAddress());

				msgHandler = new MessageHandler(client, view);
				msgHandler.start();
				clients.add(msgHandler);
			} catch (SocketException e) {
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
		for (int i =0; i <clients.size() ; i++) {
			MessageHandler msgHandler = clients.remove(i);	
			msgHandler.setStopped(true);
		}
		clients = null;
	}
}