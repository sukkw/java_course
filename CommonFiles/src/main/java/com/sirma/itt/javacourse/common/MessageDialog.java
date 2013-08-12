package com.sirma.itt.javacourse.common;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * This class is used to show different message dialog depending on
 * type.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public class MessageDialog {

	/**
	 * Show error or information messge.
	 * @param component - the frame where the messge dialog have to be shown
	 * @param message - the message
	 * @param type - message type (error or warning)
	 */
	public static void showMessage(Component component, String message, int type) {
		switch (type) {
		case 1:
			JOptionPane.showMessageDialog(component, message, "Error",
					JOptionPane.ERROR_MESSAGE);
			break;
		case 2:
			JOptionPane.showMessageDialog(component, message, "Information",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
}
