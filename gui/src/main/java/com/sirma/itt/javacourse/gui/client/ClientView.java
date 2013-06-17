package com.sirma.itt.javacourse.gui.client;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

/**
 * Client view. Creates GUI.
 *
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class ClientView extends JFrame {

	private static final long serialVersionUID = 787881622153773060L;
	private JTextArea messageArea;
	private JScrollPane scroll;

	/**
	 * Constructor. 
	 * Initialize all graphic components and show it on screen.
	 */
	public ClientView() {

		messageArea = new JTextArea(15, 20);
		scroll = new JScrollPane(messageArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		messageArea.setEnabled(false);
		messageArea.setDisabledTextColor(new Color(0, 0, 0));

		setTitle("Client");
		setSize(200, 100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(scroll, BorderLayout.WEST);

		pack();
		setVisible(true);
		setLocation(400, 350);
	}

	/**
	 * Show message in text area.
	 * @param msg - message to be shown
	 */
	public void showMessage(String msg) {
		messageArea.append(msg + "\n");
	}
	
	/**
	 * Show error message.
	 * @param msg - message to be shown
	 */
	public void showError(String msg) {
		JOptionPane.showMessageDialog(this, msg,
				"Client error", JOptionPane.ERROR_MESSAGE);
	}
}