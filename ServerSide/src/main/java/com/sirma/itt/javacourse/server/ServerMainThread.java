package com.sirma.itt.javacourse.server;

import java.io.*;
import java.net.*;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.common.MessageDialog;
import com.sirma.itt.javacourse.config.Config;
import com.sirma.itt.javacourse.lang.LangBundleHandler;
import com.sirma.itt.javacourse.servercommands.DisconnectedCommand;

/**
 * This class takes care about main server functionality. 
 * It starts server, stops server, and listen for clients
 * while server is running.
 * 
 * @version 1.1 29 July 2013
 * @author Stella Djulgerova
 */
public class ServerMainThread extends Thread {

	// class private members
	private ServerSocket server;
	private boolean isRunning;
	private ServerGUI serverGUI;
	private int port;
	private ClientData client;
	private MessagesReadThread reader;
	
	// language bundle and logger
	private ResourceBundle bundle;
	private Logger log = Logger.getLogger(ServerMainThread.class.getName());

	/**
	 * Constructor. Initialize variables.
	 * @param serverGUI - reference to server gui
	 * @param port - port number
	 */
	public ServerMainThread(ServerGUI serverGUI, int port) {
		this.serverGUI = serverGUI;
		this.port = port;
		this.bundle = LangBundleHandler.getBundle();
	}

	/**
	 * Starts server and keep on listen for new clients while server is running.
	 */
	public void run() {
		startServer(port);
		while (isRunning) {
			try {
				acceptClient(server.accept());
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Starts server at chosen port.
	 */
	public void startServer(int port) {
		try {
			server = new ServerSocket(port);
			serverGUI.showMessage(bundle.getString("server_started_IP") + InetAddress.getLocalHost()
					+ " " + bundle.getString("server_started_port") + server.getLocalPort());
			serverGUI.showMessage(bundle.getString("wait_clients"));
			log.info(Config.SERVER_STARTED);
			serverGUI.disableStartButton();
			serverGUI.getConfigPanel().setVisible(false);
			serverGUI.pack();
			
			isRunning = true;
		} catch (IOException ioe) {
			MessageDialog.showMessage(serverGUI, bundle.getString("port_in_use"), 1);
			log.warn(Config.PORT_IN_USE);
		}
	}

	/**
	 * Stops server.
	 */
	public void stopServer() {
		isRunning = false;
		try {
			if (server != null) {
				new DisconnectedCommand().execute();
				server.close();
				log.info(Config.SERVER_STOPPED);
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.warn(Config.STOP_ERROR);
		}
	}

	/**
	 * Accept client and starts thread for messages.
	 * @param socket - client socket
	 */
	private void acceptClient(Socket socket) {
		try {
			client = new ClientData(socket);
			reader = new MessagesReadThread(serverGUI, client);
			reader.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}