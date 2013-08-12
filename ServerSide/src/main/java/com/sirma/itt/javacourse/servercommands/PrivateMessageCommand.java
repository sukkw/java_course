package com.sirma.itt.javacourse.servercommands;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.server.ClientHandler;

/**
 * This class execute private message server command.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class PrivateMessageCommand extends Command {

	// class private members
	private ClientHandler clientHandler;
	private int id;
	private Message msg;
	
	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param id - client ID
	 * @param msg - client message
	 */
	public PrivateMessageCommand(int id, Message msg) {
		clientHandler = ClientHandler.getInstance();
		this.id = id;
		this.msg = msg;
	}
	
	/**
	 * Execute command.
	 */
	public void execute() {
		clientHandler.getClientByName(msg.recipient).sendMessage(
				new Message(ServerMessages.PRIVATE_MESSAGE, msg.sender, msg.content,
						msg.recipient));
		clientHandler.getClientByID(id).sendMessage(
				new Message(ServerMessages.PRIVATE_MESSAGE, msg.sender, msg.content,
						msg.recipient));
	}
}