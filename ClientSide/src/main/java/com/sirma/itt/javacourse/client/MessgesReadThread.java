package com.sirma.itt.javacourse.client;

import java.util.ResourceBundle;

import com.sirma.itt.javacourse.common.ClientMessages;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.MessageDialog;
import com.sirma.itt.javacourse.common.ServerMessages;
import com.sirma.itt.javacourse.lang.LangBundleHandler;

/**
 * This thread is used to read messages from server. 
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class MessgesReadThread extends Thread {

	// class private members
	private ClientGUI clientGUI;
	private ServerData server;
	private ResourceBundle bundle;
	
	/**
	 * Constructor. Initialize all needed variables.
	 * 
	 * @param serverGUI
	 * @param client
	 */
	public MessgesReadThread(ClientGUI clientGUI, ServerData server) {
		this.bundle = LangBundleHandler.getBundle();
		this.clientGUI = clientGUI;
		this.server = server;
	}

	/**
	 * Read messages from server.
	 */
	public void run() {
		Message msg = null;
		
		while ((msg = server.readMessage()) != null) {
			handle(msg);
		}
	}
	
	public synchronized void handle(Message msg) {
		// unknown command. Connection is closed.
		if (msg.type.equals(ServerMessages.UNKNOWN)) {
			MessageDialog.showMessage(clientGUI, bundle.getString("unknown"), 1);
			server.close();
			clientGUI.dispose();
			return;
		}

		// online users list is updated
		else if (msg.type.equals(ServerMessages.CLIENTS_LIST)) {
			clientGUI.model.addElement(msg.content);
			return;
		}
		
		// new user join chat. Message is displayed
		else if (msg.type.equals(ServerMessages.NEW_USER)) {
			clientGUI.model.addElement(msg.recipient);
			msg.content = msg.recipient + bundle.getString("connected");
		} 

		
		// user is rejected by server
		else if (msg.type.equals(ServerMessages.LOGIN)) {
			MessageDialog.showMessage(clientGUI, bundle.getString(msg.content), 1);
			server.sendMessage(new Message("message", clientGUI.username, ClientMessages.LOGIN_FAIL,
					"SERVER"));
		} 
		
		// user enter chat successfully
		else if (msg.type.equals(ServerMessages.APPROVED)) {
			clientGUI.showChat();
			msg.content = bundle.getString("welcome") + msg.recipient;
		} 
		
		// user log off
		else if (msg.type.equals(ServerMessages.LOGOFF)) {
			clientGUI.model.removeElement(msg.recipient);
			msg.content = msg.recipient +  bundle.getString("disconnected");
		}
		
		clientGUI.showMessge(msg);
	}
}