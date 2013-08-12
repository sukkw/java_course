package com.sirma.itt.javacourse.servercommands;

import java.util.ResourceBundle;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.common.Validator;
import com.sirma.itt.javacourse.lang.LangBundleHandler;
import com.sirma.itt.javacourse.server.ClientHandler;

/**
 * This class represents login server command.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class LoginCommand extends Command {

	// class private members
	private ClientHandler clientHandler;
	private int ID;
	private Message msg;
	private ResourceBundle bundle;

	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param ID - client ID
	 * @param msg - client message
	 */
	public LoginCommand(int ID, Message msg) {
		clientHandler = ClientHandler.getInstance();
		this.ID = ID;
		this.msg = msg;
		bundle = LangBundleHandler.getBundle();
	}

	/**
	 * Execute the command.
	 */
	public void execute() {

		// check is entered nickname empty
		if("".equals(msg.sender)) {
			clientHandler.getClientByID(ID).sendMessage(
					new Message(ServerMessages.LOGIN, ServerMessages.SERVER, "empty",
							msg.sender));
			return;
		}

		// check is entered by user nickname unique
		if (clientHandler.getClientByName(msg.sender) == null) {

			// check is entered by user nickname valid
			if (Validator.validate(msg.sender) == null) {

				clientHandler.getClientByID(ID).setUsername(msg.sender);
				clientHandler.getClientByID(ID).sendMessage(
						new Message(ServerMessages.APPROVED, ServerMessages.SERVER,
								msg.sender, msg.sender));
				notifyObserver(bundle.getString("user") + msg.sender + " "
						+ bundle.getString("logged"));
				clientHandler.announce(ServerMessages.NEW_USER, ServerMessages.SERVER, msg.sender);
				notifyObserver(bundle.getString("notified"));
				clientHandler.sendUserList(msg.sender);
				notifyObserver(bundle.getString("user_added"));
				notifyObserver(bundle.getString("thread"));
			} else {
				clientHandler.getClientByID(ID).sendMessage(
						new Message(ServerMessages.LOGIN, ServerMessages.SERVER, Validator
								.validate(msg.sender), msg.sender));
			}
		} else {
			clientHandler.getClientByID(ID).sendMessage(
					new Message(ServerMessages.LOGIN, ServerMessages.SERVER, "in_use",
							msg.sender));
		}
	}
}