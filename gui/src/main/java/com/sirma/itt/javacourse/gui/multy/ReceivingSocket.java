package com.sirma.itt.javacourse.gui.multy;

import java.net.*;

import sun.net.*;
import java.io.*;



public class ReceivingSocket {



  public static void main(String[] args) {

	    // Which port should we listen to
	    int port = 5000;
	    // Which address
	    String group = "225.4.5.6";

	    // Create the socket and bind it to port 'port'.
	    MulticastSocket s = null;
		try {
			s = new MulticastSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // join the multicast group
	    try {
			s.joinGroup(InetAddress.getByName(group));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // Now the socket is set up and we are ready to receive packets

	    // Create a DatagramPacket and do a receive
	    byte buf[] = new byte[1024];
	    DatagramPacket pack = new DatagramPacket(buf, buf.length);
	    try {
			s.receive(pack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Finally, let us do something useful with the data we just received,
	    // like print it on stdout :-)
	    System.out.println("Received data from: " + pack.getAddress().toString() +
	    		    ":" + pack.getPort() + " with length: " +
	    		    pack.getLength());
	    System.out.write(pack.getData(),0,pack.getLength());
	    System.out.println();

	    // And when we have finished receiving data leave the multicast group and
	    // close the socket
	    try {
			s.leaveGroup(InetAddress.getByName(group));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    s.close();



  }
}