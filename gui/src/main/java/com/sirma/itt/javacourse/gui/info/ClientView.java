package com.sirma.itt.javacourse.gui.info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Client view. Creates GUI.
 *
 * @version 1.1 17 June 2013
 * @author Stella Djulgerova
 */
public class ClientView extends JFrame {

	private static final long serialVersionUID = -6588131873294178420L;
	private JTextArea messageArea;
	private JScrollPane scroll;
	private JButton btnConnect;
	
	public ClientView() {

		messageArea = new JTextArea(15, 20);
		scroll = new JScrollPane(messageArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		messageArea.setEnabled(false);
		messageArea.setDisabledTextColor(new Color(0, 0, 0));
		
		btnConnect = new JButton("Connect");
		btnConnect.setActionCommand("connect");
		
		setTitle("Client");
		setSize(200, 100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(scroll, BorderLayout.NORTH);
		getContentPane().add(btnConnect, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setLocation(400, 350);
	}
	
	public void addListeners(ActionListener listener) {
		btnConnect.addActionListener(listener);
	}
	
	/**
	 * Enables the connect button if needed.
	 */
	public void enableConnectButton() {
		btnConnect.setEnabled(true);
	}
	
	/**
	 * Enables the connect button if needed.
	 */
	public void disableConnectButton() {
		btnConnect.setEnabled(false);
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
		JOptionPane.showMessageDialog(this, msg, "Error",
					JOptionPane.ERROR_MESSAGE);
	}
}