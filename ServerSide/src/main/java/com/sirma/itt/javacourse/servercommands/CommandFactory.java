package com.sirma.itt.javacourse.servercommands;

import com.sirma.itt.javacourse.common.ClientMessages;
import com.sirma.itt.javacourse.common.Message;

/**
 * This class is used to create different server commands
 * using factory pattern. Depending on the client message 
 * different server command is instantiated.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class CommandFactory {

	/**
	 * Instantiate server command.
	 * 
	 * @param ID - client ID
	 * @param message - client message
	 * @return server command
	 */
	public Command createCommand(int ID, Message message) {

		// logoff command is created
		if (message.content.equals(ClientMessages.LOGOFF)) {
			return new LogoffCommand(ID, message);
		}

		// login failed command is created
		if (message.content.equals(ClientMessages.LOGIN_FAIL)) {
			return new LoginFailedCommand(ID);
		}
		
		// private or standard command is created
		if (message.type.equals(ClientMessages.MESSAGE)) {
			if (message.recipient.equals(ClientMessages.ALL)) {
				return new MessageCommand(message);
			} else {
				return new PrivateMessageCommand(ID, message);
			}
		} 
		
		// login command is created
		if (message.type.equals(ClientMessages.LOGIN)) {
			return new LoginCommand(ID, message);
		} 
		
		// Unknown request from user. 
		// Unknown server command is created.
		return new UnknowCommand(ID);
	}
}