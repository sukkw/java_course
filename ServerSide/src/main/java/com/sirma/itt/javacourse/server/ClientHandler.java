package com.sirma.itt.javacourse.server;

import java.util.Iterator;
import java.util.Vector;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ServerMessages;

/**
 * This class works like mediator. It's used to add, search and remove clients.
 * 
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class ClientHandler {

	// class private members
	private Vector<ClientData> clients;
	private static ClientHandler instance = null;
	
	/**
	 * Constructor. Make constructor private to avoid instantiating.
	 */
	private ClientHandler() {
		clients = new Vector<ClientData>(50);
	}
	
	/**
	 * Override clone method to avoid make another instance using clone.
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * Get instance of the class. Must be synchronized for threads safe.
	 * @return instance of the class
	 */
	public static ClientHandler getInstance() {
		synchronized (ClientHandler.class) {
			if(instance == null) {
				instance = new ClientHandler();
			} 
		}
		return instance;
	}

	/**
	 * Find client by given ID
	 * @param ID - client ID
	 * @return - position in the vector
	 */
	public synchronized int findClient(int ID) {
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getID() == ID) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Get client from clients list.
	 * @param ID - client ID
	 * @return client
	 */
	public synchronized ClientData getClientByID(int ID) {
		return clients.get(findClient(ID));
	}
	
	/**
	 * Get client from client list.
	 * @param nickname - client unique nickname
	 * @return client
	 */
	public synchronized ClientData getClientByName(String nickname) {
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getUsername().equalsIgnoreCase(nickname)) {
				return clients.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Add new client to the clients list
	 * @param client - new client
	 */
	public synchronized void addClient(ClientData client) {
		clients.add(client);
		client.sendMessage(new Message("", "", ServerMessages.CHAT, ""));
	}
	
	/**
	 * Remove client from client list
	 * @param ID - client ID
	 */
	public synchronized void removeClient(int ID) {
		int pos = findClient(ID);
		if (pos >= 0) {
			ClientData removeClient = clients.remove(pos);
			removeClient.close();
		}
	}
	
	/**
	 * Remove all clients from client list
	 * @param ID - client ID
	 */
	public synchronized void removeAll() {
		Iterator<ClientData> it = clients.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}
	
	/**
	 * Send message to all online users
	 * @param type - message type
	 * @param sender - message sender
	 * @param content - message content
	 */
	public synchronized void sendToAll(String type, String sender, String content) {
		Message msg = new Message(type, sender, content, "");
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).sendMessage(msg);
		}
	}

	/**
	 * Announce important event (user connected, user disconnected etc...)
	 * @param type - message type
	 * @param sender - message sender
	 * @param content - message content
	 */
	public synchronized void announce(String type, String sender, String content) {
		Message msg = new Message(type, sender, content, content);

		for (int i = 0; i < clients.size(); i++) {
			if (!clients.get(i).getUsername().equalsIgnoreCase(content)) {
				clients.get(i).sendMessage(msg);
			}
		}
	}

	/**
	 * Send client list.
	 * @param nickname - client nickname 
	 */
	public synchronized void sendUserList(String nickname) {
		ClientData receiver = getClientByName(nickname);
		
		for (int i = 0; i < clients.size(); i++) {
			if (!clients.get(i).getUsername().equalsIgnoreCase(nickname)) {
				receiver.sendMessage(
					new Message(ServerMessages.CLIENTS_LIST, ServerMessages.SERVER, clients.get(i).getUsername(),
							nickname));
			}
		}
	} 
}