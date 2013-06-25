package com.sirma.itt.javacourse.gui;

import java.lang.reflect.Field;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.sirma.itt.javacourse.gui.client.Client;
import com.sirma.itt.javacourse.gui.client.ClientView;
import com.sirma.itt.javacourse.gui.client.Server;
import com.sirma.itt.javacourse.gui.client.ServerView;

public class ClientTest {
	
	// class private members
	private ServerView serverView ;
	private Server server;
	private ClientView cleintView;
	private Client client;
	
	/**
	 * Start server and client.
	 */
	@BeforeSuite
	public void startSockets() {
		serverView = new ServerView();
		server = new Server(serverView);
		cleintView = new ClientView();
		client = new Client(cleintView);
	}
	
	/**
	 * Test receive and send methods
	 */
	@Test
	public void sendReceiveTest() {

		try {
			Field f = server.getClass().getDeclaredField("message");
			f.setAccessible(true);
			String sentMessage = (String) f.get(server);
			f.setAccessible(false);
			
			f = client.getClass().getDeclaredField("message");
			f.setAccessible(true);
			String receivedMessage = (String) f.get(client);
			f.setAccessible(false);
			
			Assert.assertEquals(sentMessage, receivedMessage);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}