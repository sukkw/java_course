package com.sirma.itt.javacourse.server;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Logger;

import com.sirma.itt.javacourse.common.LogFileHandler;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.MessageDialog;
import com.sirma.itt.javacourse.common.Validator;

class ServerThread extends Thread {

	public SocketServer server = null;
	public Socket socket = null;
	public int ID = -1;
	public String username = "";
	public ObjectInputStream streamIn = null;
	public ObjectOutputStream streamOut = null;
	public ServerFrame ui;

	public ServerThread(SocketServer server, Socket socket) {
		super();
		this.server = server;
		this.socket = socket;
		ID = socket.getPort();
		ui = server.ui;
	}

	public void send(Message msg) {
		try {
			streamOut.writeObject(msg);
			streamOut.flush();
		} catch (IOException ex) {
			System.out.println("Exception [SocketClient : send(...)]");
		}
	}

	public int getID() {
		return ID;
	}

	public void run() {
		ui.showMessage("Server Thread " + ID + " running.");
		while (true) {
			try {
				Message msg = (Message) streamIn.readObject();
				server.handle(ID, msg);
			} catch (Exception ioe) {
				System.out.println(ID + " ERROR reading: " + ioe.getMessage());
				server.remove(ID);
				stop();
			}
		}
	}

	public void open() throws IOException {
		streamOut = new ObjectOutputStream(socket.getOutputStream());
		streamOut.flush();
		streamIn = new ObjectInputStream(socket.getInputStream());
	}

	public void close() throws IOException {
		if (socket != null)
			socket.close();
		if (streamIn != null)
			streamIn.close();
		if (streamOut != null)
			streamOut.close();
	}
}

public class SocketServer implements Runnable {

	public Vector<ServerThread> clients;
	public ServerSocket server = null;
	public Thread thread = null;
	public ServerFrame ui;

	private ResourceBundle bundle;
	private Logger log = Logger.getLogger("SocketServer");

	public SocketServer(ServerFrame frame) {

		clients = new Vector<ServerThread>(50);
		ui = frame;

		ui.addServerMouseListener(new ServerMouseListener());
		ui.addServerActionListener(new ServerActionPerformed());
		ui.addWindowListener(new ServerWindowListener());
		log.addHandler(LogFileHandler.getHandler());
	}

	public void run() {
		while (thread != null) {
			try {
				ui.showMessage("Waiting for a client ...");
				addThread(server.accept());
			} catch (Exception ioe) {
				ioe.printStackTrace();
				ui.showMessage("Server accept error: ");

			}
		}
	}

	public void connect(int port) {
		try {
			server = new ServerSocket(port);
			port = server.getLocalPort();
			ui.showMessage("Server startet. IP : " + InetAddress.getLocalHost()
					+ ", Port : " + server.getLocalPort());
			start();
		} catch (IOException ioe) {
			MessageDialog.showMessage(ui, "port in use", 1);
			ui.showMessage("Can not bind to port : " + port + "\nRetrying");
		}
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		if (thread != null) {
			thread.stop();
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			thread = null;
		}
	}

	private int findClient(int ID) {
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getID() == ID) {
				return i;
			}
		}
		return -1;
	}

	public synchronized void handle(int ID, Message msg) {
		if (msg.content.equals(".bye")) {
			sendToAll("signout", "SERVER", msg.sender);
			remove(ID);
		}

		else if (msg.type.equals("message")) {
			if (msg.recipient.equals("All")) {
				sendToAll("message", msg.sender, msg.content);
			} else {
				findUserThread(msg.recipient).send(
						new Message(msg.type, msg.sender, msg.content,
								msg.recipient));
				clients.get(findClient(ID)).send(
						new Message(msg.type, msg.sender, msg.content,
								msg.recipient));
			}
		} else if (msg.type.equals("signup")) {

			if (findUserThread(msg.sender) == null) {
				if (Validator.validate(msg.sender) == null) {

					clients.get(findClient(ID)).username = msg.sender;
					clients.get(findClient(ID))
							.send(new Message("signup", "SERVER", "TRUE",
									msg.sender));

					sendToAll("newuser", "SERVER", msg.sender);
					announceNew("newuserz", "SERVER", msg.sender);
					sendUserList(msg.sender);
				} else {
					clients.get(findClient(ID)).send(
							new Message("signup", "SERVER", Validator
									.validate(msg.sender), msg.sender));
					
					remove(ID);
				}
			} else {
				clients.get(findClient(ID)).send(
						new Message("signup", "SERVER", "Usename in use",
								msg.sender));

			}
		} else {
			clients.get(findClient(ID)).send(
					new Message("unknown", "SERVER", "TRUE", msg.sender));
		}
	}

	public void sendToAll(String type, String sender, String content) {
		Message msg = new Message(type, sender, content, "All");
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).send(msg);
		}
	}

	// Can you make something smarter here??
	public void announceNew(String type, String sender, String content) {
		Message msg = new Message(type, sender, content, "All");

		for (int i = 0; i < clients.size(); i++) {
			if (!clients.get(i).username.equalsIgnoreCase(content)) {
				clients.get(i).send(msg);
			}
		}
	}

	public void sendUserList(String toWhom) {
		for (int i = 0; i < clients.size(); i++) {
			findUserThread(toWhom).send(
					new Message("newuser", "SERVER", clients.get(i).username,
							toWhom));
		}
	}

	public ServerThread findUserThread(String usr) {
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).username.equalsIgnoreCase(usr)) {
				return clients.get(i);
			}
		}
		return null;
	}

	public synchronized void remove(int ID) {
		int pos = findClient(ID);
		System.out.println("remove? " + pos);
		if (pos >= 0) {
			ServerThread toTerminate = clients.remove(pos);
			ui.showMessage("Removing client thread " + ID + " at " + pos);
			try {
				toTerminate.close();
			} catch (IOException ioe) {
				ui.showMessage("Error closing thread: " + ioe);
			}
			toTerminate.stop();
		}
	}

	private void addThread(Socket socket) {

		try {
			ServerThread newClient = new ServerThread(this, socket);
			newClient.open();
			newClient.start();
			clients.add(newClient);
			ui.showMessage("Client accepted: " + socket);
		} catch (IOException ioe) {
			ui.showMessage("Error opening thread: " + ioe);
		}

	}

	// Inner class. Create listener
	class ServerMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			try {
				if ("BG".equals(e.getComponent().getName())) {
					bundle = ResourceBundle.getBundle(
							"com.sirma.itt.javacourse.lang.LangResource",
							Locale.US);
					ui.updateComponents(bundle);
					log.info("Language is changed to english.");
					return;
				}
				if ("EN".equals(e.getComponent().getName())) {
					bundle = ResourceBundle.getBundle(
							"com.sirma.itt.javacourse.lang.LangResource",
							new Locale("bg"));
					ui.updateComponents(bundle);
					log.info("Language is changed to bulgarian.");
					return;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public void mouseEntered(MouseEvent e) {
			ui.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			ui.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}

	// inner class
	class ServerActionPerformed implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			if ("start".equals(ae.getActionCommand())) {
				ui.disableStartButton();

				Integer portNumber = new Integer((String) ui.getPortsList()
						.getSelectedItem());
				connect(portNumber);
				ui.getConfigPanel().setVisible(false);
				ui.pack();
				// isStarted = true;

			} else if ("stop".equals(ae.getActionCommand())) {
				stop();
				// isStarted = false;
				ui.enableStartButton();
				ui.getConfigPanel().setVisible(true);
				ui.showMessage(null);
				ui.pack();
			}
		}
	}

	// inner class
	class ServerWindowListener extends WindowAdapter {

		// stop server and close the frame
		public void windowClosing(WindowEvent evt) {
			stop();
			ui.dispose();
			log.info("Server console is closed.");
		}
	}
}
