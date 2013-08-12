package com.sirma.itt.javacourse.common;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is used to create message object.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class Message implements Serializable {

	// class private members
	private static final long serialVersionUID = 1L;
	public String type;
	public String date;
	public String sender;
	public String content;
	public String recipient;

	/**
	 * Constructor. Initialize all variables.
	 * @param type - message type
	 * @param sender - message sender
	 * @param content - message content
	 * @param recipient - message recipient
	 */
	public Message(String type, String sender, String content, String recipient) {
		this.date = new SimpleDateFormat("hh:mm:ss").format( new Date());
		this.type = type;
		this.sender = sender;
		this.content = content;
		this.recipient = recipient;
	}
}
