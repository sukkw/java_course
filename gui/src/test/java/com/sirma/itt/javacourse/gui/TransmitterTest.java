package com.sirma.itt.javacourse.gui;

import java.lang.reflect.Field;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.gui.multy.ChannelsSwitcher;
import com.sirma.itt.javacourse.gui.multy.Receiver;
import com.sirma.itt.javacourse.gui.multy.ReceiverView;
import com.sirma.itt.javacourse.gui.multy.Transmitter;
import com.sirma.itt.javacourse.gui.multy.TransmitterView;

public class TransmitterTest {
	
	// class private members
	private Transmitter transmitter ;
	private Receiver receiver;
	
	/**
	 * Start server and client.
	 */
	@BeforeSuite
	public void startSockets() {
		
		receiver = new Receiver(new ReceiverView());
		receiver.start();
		
		transmitter = new Transmitter(new TransmitterView(), new ChannelsSwitcher());
	}
	
	/**
	 * Test receive and send methods
	 */
	@Test
	public void sendReceiveTest() {
		
		try {
			Field f = transmitter.getClass().getDeclaredField("message");
			f.setAccessible(true);
			String sentMessage = (String) f.get(transmitter);
			f.setAccessible(false);
			
			f = receiver.getClass().getDeclaredField("message");
			f.setAccessible(true);
			String receivedMessage = (String) f.get(receiver);
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
