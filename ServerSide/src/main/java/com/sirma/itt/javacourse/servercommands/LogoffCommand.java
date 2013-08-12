package com.sirma.itt.javacourse.servercommands;

import java.util.ResourceBundle;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;
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
	private ClientHandler clientManager;
	private int ID;
	private Message msg;
	private ResourceBundle bundle;
	
	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param ID - client ID
	 * @param msg - client message
	 */
	public LogoffCommand(int ID, Message msg) {
		clientManager = ClientHandler.getInstance();
		this.ID = ID;
		this.msg = msg;
		bundle = LangBundleHandler.getBundle();
	}
	
	/**
	 * Execute command.
	 */
	public void execute() {
		clientManager.announce(ServerMessages.LOGOFF, ServerMessages.SERVER, msg.sender);
		clientManager.removeClient(ID);
		notifyObserver(msg.sender + " " + bundle.getString("logoff"));
	}
}