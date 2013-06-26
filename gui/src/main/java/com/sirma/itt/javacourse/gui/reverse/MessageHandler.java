package com.sirma.itt.javacourse.gui.reverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * MessageHandler class. Read client message and write it reversed.
 *
 * @version 1.1 19 June 2013
 * @author Stella Djulgerova
 */
public class MessageHandler extends Thread {

	// class private members
	private Socket client;
	private PrintWriter printWriter;
	private BufferedReader reader;
	private StringBuffer msgBuilder;
	private ServerView view;
	private boolean stopped;

	/**
	 * Constructor. Initialize variables.
	 * 
	 * @param client - client
	 * @param view - GUI
	 */
	public MessageHandler(Socket client, ServerView view) {
		this.view = view;
		this.client = client;
		createStreams();
	}

	/**
	 * Open needed streams.
	 */
	private void createStreams() {
		try {
			printWriter = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream())), true);
			reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read message from client.
	 * 
	 * @return client message
	 * @throws IOException
	 */
	private String readClientMessage() throws IOException {
		String str = reader.readLine();
		return str;
	}

	/**
	 * Reverse client message.
	 * 
	 * @param message
	 */
	private void writeReversedMessage(String message) {
		if(message == null) {
			return;
		}
		msgBuilder = new StringBuffer(message);
		msgBuilder.reverse();
		printWriter.println(msgBuilder.toString());
	}

	/**
	 * Show client message. Disconnect client if "." is entered.
	 */
	public void run() {
		createStreams();
		String clientMessage;
		try {
			while (true) {
				clientMessage = readClientMessage();
				if(isStopped()) {
					break;
				}
				if (".".equals(clientMessage)) {
					view.showMessage("Client " + client.hashCode()
							+ " disconnected...");
					close();
					break;
				} else {
					view.showMessage("Client " + client.hashCode()
							+ " send : [ " + clientMessage + " ]");
					writeReversedMessage(clientMessage);
				}
			}
			close();
		} catch (IOException e) {
		}
	}

	/**
	 * Close reader, writer and socket
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		reader.close();
		printWriter.close();
		client.close();
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
}