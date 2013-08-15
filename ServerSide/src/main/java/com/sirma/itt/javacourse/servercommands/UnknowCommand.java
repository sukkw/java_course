package com.sirma.itt.javacourse.servercommands;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.server.ClientHandler;

/**
 * This class represents unknown server command.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class UnknowCommand extends Command {

	// class private members
	private ClientHandler clientHandler;
	private int id;

	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param id - client ID
	 * @param msg - client message
	 */
	public UnknowCommand(int id) {
		clientHandler = ClientHandler.getInstance();
		this.id = id;
	}

	/**
	 * Execute command.
	 */
	public void execute() {
		clientHandler.getClientByID(id).sendMessage(
				new Message(ServerMessages.UNKNOWN, "", "", ""));
		clientHandler.getClientByID(id).close();
	}
}
