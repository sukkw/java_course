package com.sirma.itt.javacourse.client;

import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import com.sirma.itt.javacourse.config.Config;
import com.sirma.itt.javacourse.lang.LangBundleHandler;

/**
 * This clase is used to create and show please wait animation while
 * the client is searching for working server on all available ports.
 * 
 * @version 1.1 01 August 2013
 * @author Stella Djulgerova
 */
public class WaitDialog {

	// class private members
	private JLabel imageLabel = new JLabel();
	private JLabel headerLabel = new JLabel();
	private ResourceBundle bundle;
	private ClientGUI clientGUI;
	private JOptionPane optionPane;
	private JDialog dialog;

	/**
	 * Constructor. Initialize variables and load animated image.
	 */
	public WaitDialog(ClientGUI clientGUI) {
		
		this.clientGUI = clientGUI;
		bundle = LangBundleHandler.getBundle();
		
		// change label font
		headerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		headerLabel.setText(bundle.getString("waiting"));
		
		// add the image label
		ImageIcon ii = new ImageIcon(this.getClass().getResource(Config.WAIT_ANIMATION));
		imageLabel.setIcon(ii);
	}

	/**
	 * Dispose dialog.
	 */
	public void dispose() {
		dialog.dispose();
	}

	/**
	 * Show please wait dialog on screen.
	 */
	public void showIcon() {

		optionPane = new JOptionPane(headerLabel.getText(),
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, new Object[] {}, null);

		dialog = optionPane.createDialog(clientGUI, "");
		dialog.getContentPane().setBackground(Color.WHITE);
		dialog.getContentPane().add(headerLabel, BorderLayout.EAST);
		dialog.getContentPane().add(imageLabel, BorderLayout.WEST);
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setSize(200, 150);
		dialog.setVisible(true);
	}
}