package com.sirma.itt.javacourse.client;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = -3940870937163532413L;

	// private ChatClient client;
	private JButton btnConnect = new JButton("connect");;
	private JButton btnClose = new JButton("close");
	private JPanel pnlButtons = new JPanel();
	private JTextField txtNick = new JTextField();

	private String nickname;
	private boolean connected;
	private Logger log = Logger.getLogger("LoginForm");

	public LoginForm() {
		super("Login");

		// connect button
		btnConnect.setActionCommand("connect");

		// close button
		btnClose.setActionCommand("close");

		pnlButtons.setLayout(new GridLayout(1, 2, 5, 5));
		pnlButtons.add(btnConnect);
		pnlButtons.add(btnClose);
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		// text area to fill nickname
		getContentPane().add(txtNick, BorderLayout.NORTH);
		txtNick.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Nickname", TitledBorder.LEADING, TitledBorder.TOP));

		pack();
		setResizable(false);
		setLocation(20, 50);
		setSize(300, 100);
		setVisible(true);
	}
}