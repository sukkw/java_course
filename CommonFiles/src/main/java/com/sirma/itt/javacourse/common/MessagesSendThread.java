package com.sirma.itt.javacourse.common;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sirma.itt.javacourse.common.Message;

/**
 * This thread is used to send messages. 
 * Message is queued first.
 * 
 * @version 1.1 01 August 2013
 * @author Stella Djulgerova
 */
public class MessagesSendThread extends Thread {

	// class private members
	private BlockingQueue<Message> messgesQueue = new LinkedBlockingQueue<Message>();
	private ObjectOutputStream outputStream;

	/**
	 * Constructor. Initialize variables.
	 * @param outputStream - client output stream
	 */
	public MessagesSendThread(ObjectOutputStream outputStream) {
		this.outputStream = outputStream;
	}

	/**
	 * Put message in messages queue.
	 * @param message - message to be queued
	 */
	public void sendMessage(Message message) {
		messgesQueue.offer(message);
	}

	/**
	 * While thread is running try to read message from
	 * queue and send it.
	 */
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				outputStream.writeObject(messgesQueue.take());
				outputStream.flush();
			} catch (IOException ex) {
			} catch (InterruptedException e) {
				
			}
		}
	}
}