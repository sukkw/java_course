package com.sirma.itt.javacourse.server;

import java.io.IOException;
import java.net.Socket;

import com.sirma.itt.javacourse.common.SocketData;

/**
 * This class is used to keep all needed information about client. 
 * IO streams, socket, ID etc..
 * The class has also methods for read and write client messages.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class ClientData extends SocketData {

	// unique ID and user name
	private int id = -1;
	private String username = "";

	/**
	 * Constructor. Initialize all needed variables and starts thread
	 * which queue and send messages.
	 * 
	 * @param socket - client socket
	 * @throws IOException 
	 */
	public ClientData(Socket socket) throws IOException {
		super(socket);
		id = socket.getPort();
	}

	/**
	 * Get client ID
	 * @return client ID
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Set client user name.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get client user name.
	 * @return client user name
	 */
	public String getUsername() {
		return username;
	}
}