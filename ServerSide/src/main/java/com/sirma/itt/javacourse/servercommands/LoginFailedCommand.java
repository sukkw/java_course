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
	private ClientHandler clientHandler;
	private int id;
	
	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param id - client ID
	 * @param msg - client message
	 */
	public LoginFailedCommand(int id) {
		clientHandler = ClientHandler.getInstance();
		this.id = id;
	}
	
	/**
	 * Execute command.
	 */
	public void execute() {
		clientHandler.removeClient(id);
	}
}