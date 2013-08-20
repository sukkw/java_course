package com.sirma.itt.javacourse.server;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.config.Config;
import com.sirma.itt.javacourse.lang.LangBundleHandler;

/**
 * This class is used as a controller. 
 * It adds all needed listeners to Server view components
 * and starts server main thread.
 * 
 * @version 1.1 28 July 2013
 * @author Stella Djulgerova
 */
public class Server {

	// class private members
	private ServerMainThread mainThread;
	private ServerGUI serverGUI;
	private Logger log = Logger.getLogger(Server.class.getName());

	/*
	 * Constructor. Add all needed listeners to server GUI.
	 * Initialize log handler.
	 */
	public Server(ServerGUI serverGUI) {
		this.serverGUI = serverGUI;
		this.serverGUI.addServerMouseListener(new ServerMouseListener());
		this.serverGUI.addServerActionListener(new ServerActionPerformed());
		this.serverGUI.addWindowListener(new ServerWindowListener());
	}

	/**
	 * Starts server main thread on chosen port
	 * @param port - chosen port
	 */
	public void startServer(int port) {
		mainThread = new ServerMainThread(serverGUI, port);
		mainThread.start();
	}

	// Inner class. Create custom mouse listener
	class ServerMouseListener extends MouseAdapter {
		
		/**
		 * Detect if mouse is clicked and change language
		 */
		public void mouseClicked(MouseEvent e) {
			try {
				if ("BG".equals(e.getComponent().getName())) {
					LangBundleHandler.setLocale(Locale.US);
					serverGUI.updateComponents(LangBundleHandler.getBundle());
					log.info(Config.ENGLISH);
					return;
				}
				if ("EN".equals(e.getComponent().getName())) {
					LangBundleHandler.setLocale(new Locale("bg"));
					System.out.println("locale " + LangBundleHandler.getBundle().getLocale());
					serverGUI.updateComponents(LangBundleHandler.getBundle());
					log.info(Config.BULGARIAN);
					return;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		/**
		 * Detect if mouse is entered and change cursor.
		 */
		public void mouseEntered(MouseEvent e) {
			serverGUI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		/**
		 * Detect if mouse exited and change cursor.
		 */
		public void mouseExited(MouseEvent e) {
			serverGUI.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}

	// Inner class. Creates custom action listener
	class ServerActionPerformed implements ActionListener {
		
		/**
		 * Starts or stops server depend on chosen operation.
		 */
		public void actionPerformed(ActionEvent ae) {

			if ("start".equals(ae.getActionCommand())) {

				Integer portNumber = new Integer((String) serverGUI.getPortsList()
						.getSelectedItem());
				startServer(portNumber);

			} else if ("stop".equals(ae.getActionCommand())) {
				mainThread.stopServer();
				serverGUI.enableStartButton();
				serverGUI.getConfigPanel().setVisible(true);
				serverGUI.showMessage(null);
				serverGUI.pack();
			}
		}
	}

	// Inner class. Creates custom window listener
	class ServerWindowListener extends WindowAdapter {
		
		/**
		 * Stops server and close the frame.
		 */
		public void windowClosing(WindowEvent evt) {
			if(mainThread != null) { 
				mainThread.stopServer();
			}
			serverGUI.dispose();
			log.info(Config.SERVER_UI_CLOSED);
		}
	}
}