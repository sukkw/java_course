package com.sirma.itt.javacourse.servermain;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import com.sirma.itt.javacourse.config.Config;
import com.sirma.itt.javacourse.server.ServerFrame;
import com.sirma.itt.javacourse.server.SocketServer;

/**
 * This class is an entry point for server. 
 * It changes the look and feel corresponding to configuration,
 * creates server GUI and starts application.
 * 
 * @version 1.1 26 July 2013
 * @author Stella Djulgerova
 */
public class ServerStartClass {

	/**
	 * The main method for the server application.
	 * @param args
	 */
    public static void main(String args[]) {

		 // try to change look and feel. If fail default is used
		 try {
			 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if (Config.LOOK_AND_FEEL.equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}
        
		 // Show GUI and starts server
		 SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               ServerFrame frame =  new ServerFrame();
               new SocketServer(frame);
            }
        });
    }
}