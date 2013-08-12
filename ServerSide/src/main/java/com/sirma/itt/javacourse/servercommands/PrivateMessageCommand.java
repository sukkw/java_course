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
	private ClientHandler clientManager;
	private int ID;
	private Message msg;
	
	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param ID - client ID
	 * @param msg - client message
	 */
	public PrivateMessageCommand(int ID, Message msg) {
		clientManager = ClientHandler.getInstance();
		this.ID = ID;
		this.msg = msg;
	}
	
	/**
	 * Execute command.
	 */
	public void execute() {
		clientManager.getClientByName(msg.recipient).sendMessage(
				new Message(ServerMessages.PRIVATE_MESSAGE, msg.sender, msg.content,
						msg.recipient));
		clientManager.getClientByID(ID).sendMessage(
				new Message(ServerMessages.PRIVATE_MESSAGE, msg.sender, msg.content,
						msg.recipient));
	}
}