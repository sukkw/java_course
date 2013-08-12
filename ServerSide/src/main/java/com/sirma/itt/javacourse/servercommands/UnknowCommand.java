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
	private ClientHandler clientManager;
	private int ID;

	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param ID - client ID
	 * @param msg - client message
	 */
	public UnknowCommand(int ID) {
		clientManager = ClientHandler.getInstance();
		this.ID = ID;
	}

	/**
	 * Execute command.
	 */
	public void execute() {
		clientManager.getClientByID(ID).sendMessage(
				new Message(ServerMessages.UNKNOWN, "", "", ""));
	}
}
