package com.sirma.itt.javacourse.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.MessagesSendThread;

/**
 * This class is used to keep all needed information about socket. 
 * The class has also methods for read and write messages.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class SocketData {

	// input and output streams
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	
	// client socket and thread for send messages
	private MessagesSendThread sendThread;
	protected Socket socket;
	
	/**
	 * Constructor. Initialize all needed variables and starts thread
	 * which queue and send messages.
	 * 
	 * @param socket - client socket
	 */
	public SocketData(Socket socket) throws IOException {
		this.socket = socket;
		openIO();
		sendThread = new MessagesSendThread(outputStream);
		sendThread.setDaemon(false);
		sendThread.start();
	}

	/**
	 * Send message.
	 * 
	 * @param message - the message
	 */
	public void sendMessage(Message message) {
		sendThread.sendMessage(message);
	}
	
	/**
	 * Get client IP.
	 * 
	 * @param message - the message
	 */
	public InetAddress getIP() {
		return socket.getInetAddress();
	}

	/**
	 * Read message.
	 * 
	 * @return the message
	 */
	public Message readMessage() {
		try {
			return (Message) inputStream.readObject();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Open input and output streams.
	 * @throws IOException 
	 */
	public void openIO() throws IOException {
		outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.flush();
		inputStream = new ObjectInputStream(socket.getInputStream());
	}

	/**
	 * Close socket and streams.
	 */
	public void close() {
		try {
			if (socket != null)
				socket.close();
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null)
				outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}