package com.sirma.itt.javacourse.common;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MessageDialog {

	public static void showMessage(Component component, String message, int type) {
		switch (type) {
		case 1:
			JOptionPane.showMessageDialog(component, message, "Error",
					JOptionPane.ERROR_MESSAGE);
			//log.warning(warningMessage);
			break;
		case 2:
			JOptionPane.showMessageDialog(component, message, "Information",
					JOptionPane.INFORMATION_MESSAGE);
			//log.info(warningMessage);
			break;
		}
	}
}
