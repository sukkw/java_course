package com.sirma.itt.javacourse.servermain;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import com.sirma.itt.javacourse.server.ServerFrame;
import com.sirma.itt.javacourse.server.SocketServer;

public class ServerStartClass {

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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               ServerFrame frame =  new ServerFrame();
               frame.setVisible(true);
               SocketServer server = new SocketServer(frame);
            }
        });
    }
}

