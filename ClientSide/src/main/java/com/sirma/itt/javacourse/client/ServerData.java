package com.sirma.itt.javacourse.client;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.net.Socket;

import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.common.SocketData;

/**
 * This class is used to keep all needed information about server.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class ServerData extends SocketData {
	
	/**
	 * Constructor. Initialize all variables
	 * 
	 * @param socket - client socket
	 * @throws StreamCorruptedException 
	 */
	public ServerData(Socket socket) throws IOException {
		super(socket);
		//this.socket.setSoTimeout(20000);
		detectConnection(socket);
	}
	
	/**
	 * Detect right server application
	 * @param socket - server socket
	 * @throws IOException
	 */
	public void detectConnection(Socket socket) throws IOException {
		if(!readMessage().content.equals(ServerMessages.CHAT)) {
			throw new IOException();
		}
	}
}
