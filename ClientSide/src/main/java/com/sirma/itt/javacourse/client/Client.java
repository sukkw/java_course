package com.sirma.itt.javacourse.client;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.SwingWorker;

import com.sirma.itt.javacourse.common.ClientMessages;
import com.sirma.itt.javacourse.common.LogFileHandler;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.MessageDialog;
import com.sirma.itt.javacourse.config.Config;
import com.sirma.itt.javacourse.lang.LangBundleHandler;

/**
 * This class is used as a controller. It adds all needed listeners to Client
 * view components and starts client at first free port.
 * 
 * @version 1.1 28 July 2013
 * @author Stella Djulgerova
 */
public class Client {

	// class private members
	private int port;
	private Socket socket;
	private ClientGUI clientGUI;
	private ServerData server;
	private Logger log = Logger.getLogger("LoginView");
	private MessgesReadThread thread;
	private ResourceBundle bundle;
	private WaitPanel plsWait;

	/**
	 * Constructor. Add all needed listeners to client GUI. Initialize log
	 * handler.
	 * 
	 * @param clientGUI - gui
	 */
	public Client(ClientGUI clientGUI) {
		log.addHandler(LogFileHandler.getHandler());
		this.clientGUI = clientGUI;
		bundle = LangBundleHandler.getBundle();

		clientGUI.addWindowListener(new ClientWindowListener());
		clientGUI.addClientActionListener(new ClientActionListener());
		clientGUI.addServerMouseListener(new ClientMouseListener());
	}

	/**
	 * Starts client at first free port
	 */
	public void startClient() {

		socket = new Socket();
		port = Config.MIN_PORT;
		
		plsWait = new WaitPanel(clientGUI);
		
		// search for server in background. While worker is searching
		// pleas wait message is displayed on screen
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

		    protected Void doInBackground() {
				// repeat while free port is found or max available is reached
				while (!socket.isConnected()) {
					System.out.println("here??? " + port);
					try {
						socket.connect(
								new InetSocketAddress(InetAddress
										.getByName(Config.HOST), port));
						server = new ServerData(socket);
					} catch (Exception e) {
						socket = new Socket();
						port++;
						if (port == Config.MAX_PORT) {
							MessageDialog.showMessage(clientGUI,
									" Can't find chat server! Maybe its not started!",
									1);
							socket = null;
							break;
						}
					}
				}
		        return null;
		    }
		   
		    protected void done() {
		    	plsWait.dispose();
		        if(server != null) {
		        	thread = new MessgesReadThread(clientGUI, server);
		        	thread.start();
				
		        	clientGUI.username = clientGUI.getTxtNick().getText();
		        	server.sendMessage(new Message(ClientMessages.LOGIN,
						clientGUI.username, "", "SERVER"));
		        }
		    }
		};
		
		worker.execute();
		plsWait.showIcon();
	}

	// inner class
	class ClientWindowListener extends WindowAdapter {

		// stop server and close the frame
		public void windowClosing(WindowEvent evt) {
			try {
				server.sendMessage(new Message(ClientMessages.MESSAGE,
						clientGUI.username, ClientMessages.LOGOFF, "SERVER"));
				clientGUI.dispose();
				log.info("Server console is closed.");
			} catch (Exception ex) {
			}
		}
	}

	// Inner class. Create custom mouse listener
	class ClientMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			try {
				if ("BG".equals(e.getComponent().getName())) {
					LangBundleHandler.setLocale(Locale.US);
					clientGUI.updateComponents(LangBundleHandler.getBundle());
					log.info("Language is changed to english.");
					return;
				}
				if ("EN".equals(e.getComponent().getName())) {
					LangBundleHandler.setLocale(new Locale("bg"));
					clientGUI.updateComponents(LangBundleHandler.getBundle());
					log.info("Language is changed to bulgarian.");
					return;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public void mouseEntered(MouseEvent e) {
			clientGUI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			clientGUI.setCursor(Cursor
					.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}

	// inner class
	class ClientActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			if ("cancel".equals(ae.getActionCommand())) {
				System.exit(0);
			}

			if ("send".equals(ae.getActionCommand())) {
				String msg = clientGUI.getSendMsgArea().getText();
				String target = clientGUI.getClientsList().getSelectedValue()
						.toString();
				
				if(clientGUI.getClientsList().getSelectedIndex() == 0) {
					target = ClientMessages.ALL;
				}

				if (!msg.isEmpty() && !target.isEmpty()) {
					server.sendMessage(new Message(ClientMessages.MESSAGE,
							clientGUI.username, msg, target));
					clientGUI.getSendMsgArea().setText("");
					clientGUI.getSendMsgArea().requestFocus();
				}
			}

			if ("connect".equals(ae.getActionCommand())) {
				startClient();
			}

			if ("logout".equals(ae.getActionCommand())) {
				try {
					server.sendMessage(new Message(ClientMessages.MESSAGE,
							clientGUI.username, ClientMessages.LOGOFF, "SERVER"));
					System.exit(0);
				} catch (Exception ex) {
				}
			}
		}
	}
}