package com.sirma.itt.javacourse.servercommands;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.sirma.itt.javacourse.common.LogFileHandler;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.config.Config;
import com.sirma.itt.javacourse.lang.LangBundleHandler;
import com.sirma.itt.javacourse.server.ClientHandler;

/**
 * This class execute logoff server command.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class LogoffCommand extends Command {

	// class private members
	private ClientHandler clientHandler;
	private int id;
	private Message msg;
	private ResourceBundle bundle;
	private Logger log = Logger.getLogger(Config.LOGOFF);

	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param id - client ID
	 * @param msg - client message
	 */
	public LogoffCommand(int id, Message msg) {
		clientHandler = ClientHandler.getInstance();
		this.id = id;
		this.msg = msg;
		bundle = LangBundleHandler.getBundle();
	}

	/**
	 * Execute command.
	 */
	public void execute() {
		clientHandler.announce(ServerMessages.LOGOFF, ServerMessages.SERVER,
				msg.sender);
		notifyObserver(bundle.getString("user")
				+ clientHandler.getClientByID(id).getID() + " / "
				+ clientHandler.getClientByID(id).getIP() + " " + " "
				+ bundle.getString("logoff"));
		
		log.addHandler(LogFileHandler.getHandler());
		log.info(Config.USER_QUIT + clientHandler.getClientByID(id).getIP());
		log.removeHandler(LogFileHandler.getHandler());
		
		clientHandler.removeClient(id);
		notifyObserver(bundle.getString("users_notified"));
	}
}