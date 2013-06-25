package com.sirma.itt.javacourse.gui.reverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageHandler extends Thread {

	private Socket client;
	private PrintWriter printWriter;
	private BufferedReader reader;
	private StringBuffer msgBuilder;
	private ServerView view;

	public MessageHandler(Socket client, ServerView view) {
		this.view = view;
		this.client = client;
		createStreams();
	}

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
}