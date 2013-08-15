package com.sirma.itt.javacourse.servercommands;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.server.ClientHandler;

/**
 * This class represents disconnected server command.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class DisconnectedCommand extends Command {

	// class private members
	private ClientHandler clientHandler;

	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param id - client ID
	 */
	public DisconnectedCommand() {
		clientHandler = ClientHandler.getInstance();
	}

	/**
	 * Execute command.
	 */
	public void execute() {
		clientHandler.sendToAll(ServerMessages.DISCONNECTED, "SERVER", "");
		clientHandler.removeAll();
	}
}
