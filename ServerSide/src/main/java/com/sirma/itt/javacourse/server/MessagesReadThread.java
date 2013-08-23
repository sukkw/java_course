package com.sirma.itt.javacourse.server;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.servercommands.Command;
import com.sirma.itt.javacourse.servercommands.CommandFactory;

/**
 * This thread is used to read messages from clients. 
 * Depending on the client message different server command is called.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class MessagesReadThread extends Thread {
	
	// client data and server gui
	private ClientData client;
	private ServerGUI serverGUI;

	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param serverGUI
	 * @param client
	 */
	public MessagesReadThread(ServerGUI serverGUI, ClientData client) {
		this.client = client;
		this.serverGUI = serverGUI;
	}
	
	/**
	 * Read messages from client.
	 */
	public void run() {
		Message msg = null;
		ClientHandler.getInstance().addClient(client);
		
		while ((msg = client.readMessage()) != null) {
			handle(client.getID(),  msg);
		}
		ClientHandler.getInstance().removeClient(client.getID());
	}
	
	/**
	 * Depending on message received from client different
	 * server command is called and executed.
	 * 
	 * @param ID - client ID
	 * @param msg
	 */
	public void handle(int ID, Message message) {
		CommandFactory commandFactory = new CommandFactory();
		Command command = commandFactory.createCommand(ID, message);
		command.addObserver(serverGUI);
		command.execute();
	}
}