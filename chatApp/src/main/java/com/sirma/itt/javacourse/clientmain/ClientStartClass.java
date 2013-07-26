package com.sirma.itt.javacourse.clientmain;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import com.sirma.itt.javacourse.client.ChatFrame;

public class ClientStartClass {
	public static void main(String args[]) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}
		 
		 SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ChatFrame().setVisible(true);
			}
		});
	}
}