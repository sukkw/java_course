package com.sirma.itt.javacourse.gui.multy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Transmitter view. Creates GUI.
 * 
 * @version 1.1 25 June 2013
 * @author Stella Djulgerova
 */
public class TransmitterView extends JFrame {

	// class private members
	private static final long serialVersionUID = -1L;
	private JTextArea messageArea;
	private JButton btnStop;
	private JScrollPane scroll;

	/**
	 * Constructor. Initialize all graphic components and show it on screen.
	 */
	public TransmitterView() {

		messageArea = new JTextArea(15, 40);
		scroll = new JScrollPane(messageArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		messageArea.setEnabled(false);
		messageArea.setDisabledTextColor(new Color(0, 0, 0));

		btnStop = new JButton("Stop");
		btnStop.setActionCommand("stop");

		setTitle("Server");
		setSize(200, 100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(scroll, BorderLayout.NORTH);
		getContentPane().add(btnStop, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setLocation(400, 100);
	}

	/**
	 * Add action listener to stop button.
	 * 
	 * @param listener  - action listener
	 */
	public void setListeners(ActionListener listener) {
		btnStop.addActionListener(listener);
	}

	/**
	 * Show message in text area.
	 * 
	 * @param msg - message to be shown
	 */
	public void showMessage(String msg) {
		messageArea.append(msg + "\n");
	}
}