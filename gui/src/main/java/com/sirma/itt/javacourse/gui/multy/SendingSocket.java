package com.sirma.itt.javacourse.gui.multy;

import java.io.IOException;
import java.net.*;

public class SendingSocket {

	public static void main(String[] args) {

		// Which port should we send to
		int port = 5000;
		// Which address
		String group = "225.4.5.6";

		// Create the socket but we don't bind it as we are only going to send
		// data
		MulticastSocket s = null;
		try {
			s = new MulticastSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Note that we don't have to join the multicast group if we are only
		// sending data and not receiving

		// Fill the buffer with some data
		byte buf[] = new byte[10];
		for (int i = 0; i < buf.length; i++)
			buf[i] = (byte) i;
		// Create a DatagramPacket
		DatagramPacket pack = null;
		try {
			pack = new DatagramPacket(buf, buf.length,
					InetAddress.getByName(group), port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Do a send. Note that send takes a byte for the ttl and not an int.
		try {
			s.send(pack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// And when we have finished sending data close the socket
		s.close();

	}
}
