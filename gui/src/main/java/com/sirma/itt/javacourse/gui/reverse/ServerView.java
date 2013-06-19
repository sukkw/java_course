package com.sirma.itt.javacourse.gui.reverse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Server view. Creates GUI.
 *
 * @version 1.1 19 June 2013
 * @author Stella Djulgerova
 */
public class ServerView extends JFrame implements ActionListener {

	// class private members
	private static final long serialVersionUID = 7823874676215205540L;
	private JTextArea messageArea;
	private JButton btnStop;
	private JScrollPane scrollPane;
	private Server server;

	/**
	 * Constructor. 
	 * Initialize all graphic components and show it on screen.
	 */
	public ServerView() {
		
		messageArea = new JTextArea(10, 30);
		messageArea.setEnabled(false);
		messageArea.setDisabledTextColor(new Color(0, 0, 0));

		btnStop = new JButton("Stop");
		btnStop.setActionCommand("stop");
		btnStop.addActionListener(this);

		scrollPane = new JScrollPane(messageArea);
		
		setTitle("Server");
		setSize(200, 100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlButtons = new JPanel();
		pnlButtons.add(btnStop);
		
		getContentPane().add(scrollPane, BorderLayout.NORTH);
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setLocation(300, 50);
		
		server = new Server(this);
		server.startServer();
	}
	
	/**
	 * Detect if button is pressed and take action
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "stop") {
			btnStop.setEnabled(false);
			server.stopServer();
		}
	}
	
	/**
	 * Show message in text area.
	 * @param msg - message to be shown
	 */
	public void showMessage(String msg) {
		messageArea.append(msg + "\n");
	}

	/**
	 * Enable start button
	 */
	public void enableStartButton() {
		btnStop.setEnabled(false);
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