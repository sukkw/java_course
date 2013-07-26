package com.sirma.itt.javacourse.client;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Logger;

import com.sirma.itt.javacourse.common.LogFileHandler;
import com.sirma.itt.javacourse.common.Message;

public class SocketClient implements Runnable {
    
    public int port;
    public String serverAddr;
    public Socket socket;
    public ChatFrame ui;
    public ObjectInputStream in;
    public ObjectOutputStream out;
    private Logger log = Logger.getLogger("LoginView");
    
    public SocketClient(ChatFrame frame) throws IOException {
    	log.addHandler(LogFileHandler.getHandler());
    	this.ui = frame;
    }
    
    public void connect() {
    	
    	socket = new Socket();	
    	port = 7000;
    	
		while(!socket.isConnected()) {
			try {	
				socket.connect(new InetSocketAddress(	
						InetAddress.getByName("localhost"), port), 15000);
	            
				out = new ObjectOutputStream(socket.getOutputStream());
				out.flush();
		        in = new ObjectInputStream(socket.getInputStream());
			} catch (UnknownHostException e1) {
				log.warning("Unknown host name provided by user.");
				ui.showWarning("Unknown host!", 1);
				socket = null;
				break;
			} catch (ConnectException e1) {
					
			} catch (NoRouteToHostException e1) {
				log.warning("Connection timeout. NoRoot to host.");
				ui.showWarning("Connection timeout. Try again later!", 1);
				break;
			} catch (IOException e1) {
				socket = new Socket();					
				port++;											
				if(port == 7005) {								
					ui.showWarning(" Can't find chat server! Maybe its not started!", 1);
					socket = null;
					break;
				}
			}			
		}
	}

 
    public void run() {
        boolean keepRunning = true;
        while(keepRunning){
            try {
                Message msg = (Message) in.readObject();
                System.out.println("Incoming : " + msg.toString());
                
                if(msg.type.equals("message")){
                    if(msg.recipient.equals(ui.username)){
                        ui.showMessage("["+msg.sender +" > Me] : " + msg.content + "\n");
                    }
                    else{
                        ui.showMessage("["+ msg.sender +" > "+ msg.recipient +"] : " + msg.content + "\n");
                    }                                           
                }

                else if(msg.type.equals("newuser")){
                	System.out.println("here");
                    if(!msg.content.equals(ui.username)){
                        boolean exists = false;
                        for(int i = 0; i < ui.model.getSize(); i++){
                            if(ui.model.getElementAt(i).equals(msg.content)){
                                exists = true; break;
                            }
                        }
                        if(!exists){ ui.model.addElement(msg.content); }
                    }
                }
                else if(msg.type.equals("signup")){
                    if(msg.content.equals("TRUE")){
                        //ui.jButton2.setEnabled(false); 
                    	//ui.jButton3.setEnabled(false);
                        //ui.jButton4.setEnabled(true); 
                    	ui.getLoginPanel().setVisible(false);
                    	ui.getConsolePanel().setVisible(true);
                    	ui.pack();
                        ui.showMessage("[SERVER] : Welcome " + msg.recipient + "\n");
                    }
                    else{
                        ui.showMessage("[SERVER] : Signup Failed\n");
                        ui.showWarning(msg.content, 1);
                    }
                }
                else if(msg.type.equals("signout")){
                    if(msg.content.equals(ui.username)){
                        ui.showMessage("["+ msg.sender +" > Me] : Bye\n");
                        //ui.jButton1.setEnabled(true); 
                        //ui.jButton4.setEnabled(false); 
                  
                        
                        for(int i = 1; i < ui.model.size(); i++){
                            ui.model.removeElementAt(i);
                        }
                        
                        ui.clientThread.stop();
                    }
                    else{
                        ui.model.removeElement(msg.content);
                        ui.showMessage("["+ msg.sender +" > All] : "+ msg.content +" has signed out\n");
                    }
                    
                }

                else{
                    ui.showMessage("[SERVER > Me] : Unknown message type\n");
                    ui.showWarning("disconnected", 1);
                    socket.close();
                    ui.dispose();
                }
            }
            catch(Exception ex) {
                keepRunning = false;
                ui.showMessage("[Application > Me] : Connection Failure\n");
                //ui.jButton1.setEnabled(true); 
              
                //ui.jButton4.setEnabled(false); 

                
                for(int i = 1; i < ui.model.size(); i++){
                    ui.model.removeElementAt(i);
                }
                
                ui.clientThread.stop();
                
                System.out.println("Exception SocketClient run()");
                ex.printStackTrace();
            }
        }
    }
    
    public void send(Message msg){
        try {
            out.writeObject(msg);
            out.flush();
            System.out.println("Outgoing : "+msg.toString());
            
            if(msg.type.equals("message") && !msg.content.equals(".bye")){
                String msgTime = (new Date()).toString();

            }
        } 
        catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }
    
    public void closeThread(Thread t){
        t = null;
    }
}
