package com.sirma.itt.javacourse.client;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.net.Socket;

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
	}
	
	public void detectConnection(Socket socket) throws Exception {
		if(!readMessage().content.equals("chat")) {
			throw new Exception();
		}
	}
}
