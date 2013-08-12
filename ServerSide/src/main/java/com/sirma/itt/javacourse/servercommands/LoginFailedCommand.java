package com.sirma.itt.javacourse.servercommands;

import com.sirma.itt.javacourse.server.ClientHandler;

/**
 * This class execute login failed server command.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class LoginFailedCommand extends Command {

	// class private members
	private ClientHandler clientManager;
	private int ID;
	
	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param ID - client ID
	 * @param msg - client message
	 */
	public LoginFailedCommand(int ID) {
		clientManager = ClientHandler.getInstance();
		this.ID = ID;
	}
	
	/**
	 * Execute command.
	 */
	public void execute() {
		clientManager.removeClient(ID);
	}
}