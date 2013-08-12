package com.sirma.itt.javacourse.servercommands;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.server.ClientHandler;

/**
 * This class execute message server command.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class MessageCommand extends Command {

	// class private members
	private ClientHandler clientManager;
	private Message msg;
	
	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param msg - client message
	 */
	public MessageCommand(Message msg) {
		clientManager = ClientHandler.getInstance();
		this.msg = msg;
	}
	
	/**
	 * Execute command.
	 */
	public void execute() {
		clientManager.sendToAll(ServerMessages.MESSAGE, msg.sender, msg.content);
	}
}