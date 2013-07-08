package com.sirma.itt.javacourse.gui.multy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Receiver view. Creates GUI.
 *
 * @version 1.1 25 June 2013
 * @author Stella Djulgerova
 */
public class ReceiverView extends JFrame {

	private static final long serialVersionUID = -6588131873294178420L;
	private JTextArea messageArea;
	private JScrollPane scroll;
	private JButton btnConnect;
	private JButton btnStop;
	
	public ReceiverView() {

		messageArea = new JTextArea(15, 40);
		scroll = new JScrollPane(messageArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		messageArea.setEnabled(false);
		messageArea.setDisabledTextColor(new Color(0, 0, 0));
		
		btnConnect = new JButton("Start");
		btnConnect.setActionCommand("connect");
		
		btnStop = new JButton("Stop");
		btnStop.setActionCommand("stop");
		
		setTitle("Receiver");
		setSize(200, 100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(scroll, BorderLayout.NORTH);
		getContentPane().add(btnConnect, BorderLayout.SOUTH);
		getContentPane().add(btnStop, BorderLayout.CENTER);

		pack();
		setVisible(true);
		setLocation(400, 350);
	}
	
	public void addListeners(ActionListener listener) {
		btnConnect.addActionListener(listener);
		btnStop.addActionListener(listener);
	}
	
	/**
	 * Enables the connect button if needed.
	 */
	public JButton getConnectButton() {
		return btnConnect;
	}
	
	/**
	 * Show message in text area.
	 * @param msg - message to be shown
	 */
	public void showMessage(String msg) {
		messageArea.append(msg + "\n");
	}
}