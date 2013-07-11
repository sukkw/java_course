package com.sirma.itt.javacourse.gui.reverse;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Client view. Creates GUI.
 * 
 * @version 1.1 19 June 2013
 * @author Stella Djulgerova
 */
public class ClientView extends JFrame implements ActionListener,
		DocumentListener {

	private static final long serialVersionUID = -1L;

	private JTextField txtMessage;
	private JTextArea console;
	private JScrollPane consoleScroll;
	private JButton btnSend;
	private JButton btnConnect;

	private JButton btnPrevious;
	private JButton btnNext;

	private Client client;

	int savedMessages = 0;
	int currentMessage = 0;
	MementoHandler caretaker = new MementoHandler();

	/**
	 * Constructor. Initialize all graphic components and show it on screen.
	 */
	public ClientView() {
		console = new JTextArea(10, 30);
		console.setEditable(false);

		txtMessage = new JTextField();
		txtMessage.setEditable(true);
		txtMessage.setEnabled(false);
		txtMessage.getDocument().addDocumentListener(this);

		consoleScroll = new JScrollPane(console);

		btnSend = new JButton("Send");
		btnSend.setActionCommand("send");
		btnSend.setEnabled(false);
		btnSend.addActionListener(this);

		btnConnect = new JButton("Connect");
		btnConnect.setActionCommand("connect");
		btnConnect.addActionListener(this);

		btnPrevious = new JButton("<<");
		btnPrevious.setActionCommand("previous");
		btnPrevious.setEnabled(false);
		btnPrevious.addActionListener(this);

		btnNext = new JButton(">>");
		btnNext.setActionCommand("next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(this);

		setTitle("Client");
		setSize(100, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlButtons = new JPanel();
		pnlButtons.add(btnConnect);
		pnlButtons.add(btnSend);

		JPanel pnlMessage = new JPanel();
		pnlMessage.add(btnPrevious);
		pnlMessage.add(btnNext);

		getContentPane().add(pnlMessage, BorderLayout.EAST);
		getContentPane().add(consoleScroll, BorderLayout.NORTH);
		getContentPane().add(pnlButtons, BorderLayout.WEST);
		getContentPane().add(txtMessage, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setLocation(300, 300);

	}

	/**
	 * Execute different operation depending on user choice.
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "connect") {
			btnConnect.setEnabled(false);
			client = new Client(this);
			client.start();
		}
		if (event.getActionCommand() == "send") {
			client.setMessage(txtMessage.getText());

			caretaker.addMemento(client.store(txtMessage.getText()));

			savedMessages++;
			currentMessage++;
			btnPrevious.setEnabled(true);

			txtMessage.setText("");
			btnSend.setEnabled(false);
			client.wakeUp();
		}
		if (event.getActionCommand() == "previous") {
			if (currentMessage >= 1) {
				currentMessage--;

				txtMessage.setText(client.restore(caretaker
						.getMemento(currentMessage)));

				btnNext.setEnabled(true);
			} else {
				btnPrevious.setEnabled(false);
			}
		}
		if (event.getActionCommand() == "next") {
			if ((savedMessages - 1) > currentMessage) {
				currentMessage++;

				txtMessage.setText(client.restore(caretaker
						.getMemento(currentMessage)));

				btnPrevious.setEnabled(true);
			} else {
				btnNext.setEnabled(false);
			}
		}
	}

	/**
	 * Enable Connect button
	 */
	public void enableConnectButton() {
		btnConnect.setEnabled(true);
	}

	/**
	 * Enable or disable message field.
	 * 
	 * @param status
	 */
	public void resetMsgField(boolean status) {
		txtMessage.setEnabled(status);
	}

	/**
	 * Show message in text area.
	 * 
	 * @param msg
	 *            - message to be shown
	 */
	public void showMessage(String msg) {
		console.append(msg + "\n");
	}

	/**
	 * Show error message.
	 * 
	 * @param msg - message to be shown
	 */
	public void showError(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void insertUpdate(DocumentEvent arg0) {
		if (!"".equals(txtMessage.getText())) {
			btnSend.setEnabled(true);
		}
	}

	public void changedUpdate(DocumentEvent arg0) {}
	public void removeUpdate(DocumentEvent arg0) {}
}