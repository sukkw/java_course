package com.sirma.itt.javacourse.servercommands;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.common.Validator;
import com.sirma.itt.javacourse.config.Config;
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
	private int id;
	private Message msg;
	private ResourceBundle bundle;
	private Logger log = Logger.getLogger(LoginCommand.class.getName());

	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param id - client ID
	 * @param msg - client message
	 */
	public LoginCommand(int id, Message msg) {
		clientHandler = ClientHandler.getInstance();
		this.id = id;
		this.msg = msg;
		bundle = LangBundleHandler.getBundle();
	}

	/**
	 * Execute the command.
	 */
	public void execute() {

		// check is entered nickname empty
		if ("".equals(msg.sender)) {
			clientHandler.getClientByID(id).sendMessage(
					new Message(ServerMessages.LOGIN, ServerMessages.SERVER,
							"empty", msg.sender));
			return;
		}

		// check is entered by user nickname unique
		if (clientHandler.getClientByName(msg.sender) == null) {

			// check is entered by user nickname valid
			if (Validator.validate(msg.sender) == null) {
				
				clientHandler.getClientByID(id).setUsername(msg.sender);
				clientHandler.getClientByID(id).sendMessage(
						new Message(ServerMessages.APPROVED,
								ServerMessages.SERVER, msg.sender, msg.sender));
				notifyObserver(bundle.getString("user")
						+ clientHandler.getClientByID(id).getID() + " / "
						+ clientHandler.getClientByID(id).getIP() + " "
						+ bundle.getString("logged"));
				
				log.info(Config.NEW_USER + clientHandler.getClientByID(id).getIP());
				
				clientHandler.announce(ServerMessages.NEW_USER,
						ServerMessages.SERVER, msg.sender);
				notifyObserver(bundle.getString("notified"));
				clientHandler.sendUserList(msg.sender);
				notifyObserver(bundle.getString("user_added"));
				notifyObserver(bundle.getString("thread"));

			} else {
				clientHandler.getClientByID(id).sendMessage(
						new Message(ServerMessages.LOGIN,
								ServerMessages.SERVER, Validator
										.validate(msg.sender), msg.sender));
			}
		} else {
			clientHandler.getClientByID(id).sendMessage(
					new Message(ServerMessages.LOGIN, ServerMessages.SERVER,
							"in_use", msg.sender));
		}
	}
}